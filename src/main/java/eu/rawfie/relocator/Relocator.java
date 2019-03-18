package eu.rawfie.relocator;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.geom.Point;
import eu.rawfie.relocator.JSON.JSON_Generator;
import eu.rawfie.relocator.JSON.JSON_parser;
import eu.rawfie.relocator.JSON.NodeEvent;
import eu.rawfie.relocator.REST.StartRecordClient;
import eu.rawfie.relocator.REST.StopRecordClient;
import eu.rawfie.relocator.coordinates.*;
import eu.rawfie.relocator.database.Database;
import eu.rawfie.uxv.Header;
import eu.rawfie.uxv.Location;
import eu.rawfie.uxv.commands.DynamicGoto;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Relocator {

    private int lastTimestep;
    private double minDistance;
    private Polygon[] testbedObstacles;

    public Relocator()
    {
        this.minDistance  = 5;
        this.lastTimestep = -1;
    }

    public int getLastTimestep() {
        return lastTimestep;
    }

    public void setMinDistance(double minDistance)
    {
        this.minDistance = minDistance;
    }

    /*Calculates the Euclidean distance between two points*/
    private double cartesianDistance(double latitude1, double longitude1, double height1,
                                     double latitude2, double longitude2, double height2)
    {
        return Math.sqrt(Math.pow(latitude1-latitude2, 2)
                + Math.pow(longitude1-longitude2, 2) + Math.pow(height1-height2, 2));
    }

    private double distance(WGS84 pointA, WGS84 pointB)
    {
        return WGS84.distance(pointA, pointB);
    }

    private double distance(NED pointA, NED pointB)
    {
        return cartesianDistance(pointA.north, pointA.east, pointA.down,
                pointB.north, pointB.east, pointB.down);
    }

    public void initTestbedObstacles()
    {
        /*create testbed obstacles polygons*/
        GeometryFactory geometryFactory = new GeometryFactory();
        String obstaclesStr = Database.getTestbedObstacles(JSON_parser.getTestbedArea());
        if ( obstaclesStr == null )
            return;

        List<String> transformedPoints;
        String [] strs = obstaclesStr.split("&");
        testbedObstacles = new Polygon[strs.length];
        for(int i = 0; i < strs.length; i++){
            transformedPoints = tranformPoints(strs[i]);
            testbedObstacles[i] = createPolygon(geometryFactory, transformedPoints);
        }
    }

    private Polygon createPolygon(GeometryFactory geometryFactory, List<String> transformedPoints)
    {
        Coordinate[] coordinates = new Coordinate[transformedPoints.size()];

        for (int i = 0; i < transformedPoints.size(); i++) {
            String [] strs = transformedPoints.get(i).split(" ");
            coordinates[i] = new Coordinate(Double.parseDouble(strs[0]), Double.parseDouble(strs[1]));
        }

        return geometryFactory.createPolygon(coordinates);
    }

    private List<String> tranformPoints(String points)
    {
        StringBuilder finalCoords = new StringBuilder("");
        String [] strs = points.substring(1, points.length() - 1).split("\\),");

        for(String str: strs){
            str = str.replace("(", "");
            str = str.replace(",", " ");
            finalCoords.append(str).append(", ");
        }
        /*remove last 2 character, because they
         are a comma and a left parenthesis*/
        finalCoords.setLength(finalCoords.length() - 3);
        strs = finalCoords.toString().split(", ");

        return new ArrayList<>(Arrays.asList(strs));
    }

    private int getTimestep(int nodeIndex, Location currentLocation)
    {
        double distance;
        String location;
        String[] coords;
        List<String> path;

        path = JSON_parser.getPaths().get(nodeIndex);
        for(int i = lastTimestep+1; i < path.size(); i++){
            location = path.get(i);
            coords = location.split(",");

            if(JSON_parser.isIndoor()){

                NED nodeLocation = new NED(currentLocation.getN(),
                                           currentLocation.getE(),
                                           currentLocation.getD());

                NED nextWaypoint = new NED(Double.parseDouble(coords[0]),
                                           Double.parseDouble(coords[1]),
                                           Double.parseDouble(coords[2]));

                distance = distance(nodeLocation, nextWaypoint);
            }
            else{

                WGS84 nextWaypoint = new WGS84(Double.parseDouble(coords[0]),
                                               Double.parseDouble(coords[1]),
                                               Double.parseDouble(coords[2]));

                WGS84 nodeLocation = new WGS84(currentLocation.getLatitude(),
                                               currentLocation.getLongitude(),
                                               currentLocation.getHeight());

                distance = distance(nodeLocation, nextWaypoint);
            }

            if (distance <= JSON_parser.getAccuracy()) {
                lastTimestep = i;
                break;
            }
        }

        return lastTimestep;
    }

    public boolean validateAlternativePath(NodeEvent nodeEvent, String condition)
    {
        List<String> newWaypoints;
        String nodeName, script;
        int timestep, nodeIndex;

        nodeName  = nodeEvent.getNodeName();

        /*the current location of the node that sent the request for the alternative path*/
        //TODO consume location of device here
        Location currentLocation = new Location(new Header("test","test",(long) 1000000000),10.0, 20.0, 30.0f,
                0.0, 0.0, 0.0, 0.0f, 0.0f);

        nodeIndex = JSON_parser.getResourceNames().indexOf(nodeName);
        timestep = getTimestep(nodeIndex, currentLocation);
        newWaypoints = nodeEvent.getWaypoints(condition);
        Coordinate[] coordinates = new Coordinate[newWaypoints.size()+1];

        /*check the path line from the last waypoint
         * of the initial path towards the new path*/
        double lat, lon, height;
        if(JSON_parser.isIndoor()){
            lat = currentLocation.getN();
            lon = currentLocation.getE();
            height = currentLocation.getD();
        }
        else{
            lat = currentLocation.getLatitude();
            lon = currentLocation.getLongitude();
            height = currentLocation.getHeight();
        }
        coordinates[0] = new Coordinate(lat, lon, height);
        for (int i = 0; i < newWaypoints.size();) {

            String[] coords = newWaypoints.get(i).split(",");
            lat = Double.parseDouble(coords[1]);
            lon = Double.parseDouble(coords[0]);
            height = Double.parseDouble(coords[2]);
            coordinates[++i] = new Coordinate(lat, lon, height);

            /*check if new waypoint is inside the testbed area*/
            if (Database.inTestbedArea(JSON_parser.getTestbedID(), newWaypoints.get(i))) {
                GeometryFactory geometryFactory = new GeometryFactory();
                Point point = geometryFactory.createPoint(new Coordinate(lat, lon));

                for (Polygon obstacle : testbedObstacles) {
                    /* collision with testbed obstacle */
                    if (obstacle.contains(point))
                        return false;
                }

                /*check distance from each node at the next timestep*/
                if (checkDistance(newWaypoints.get(i), timestep + 1, nodeIndex))
                    return false;
            }
        }
        /*check that the new path line does not cross any obstacles */
        GeometryFactory geometryFactory = new GeometryFactory();
        LineString lineString = geometryFactory.createLineString(coordinates);
        for (Polygon obstacle : testbedObstacles) {
            /* collision with testbed obstacle */
            if(lineString.crosses(obstacle))
                return false;
        }

        script = JSON_Generator.generateScript(nodeName, timestep+1, condition, nodeEvent).toString();
        //JSONObject experimentChangeRequest = JSON_Generator.generateExperimentChangeRequest(script, false);
        //TODO producer to post experimentChangeRequest to RC

        return true;
    }

    public boolean validateAlternativePath(DynamicGoto dynamicGoto, int partition)
    {
        String newWaypoint;
        int timestep, nodeIndex;
        double lat, lon, height;

        /*the current location of the node that sent the request for the alternative path*/
        //TODO consume location of device here
        Location location = new Location(new Header("test","test",(long) 1000000000),10.0, 20.0, 30.0f,
                0.0, 0.0, 0.0, 0.0f, 0.0f);

        nodeIndex = JSON_parser.getPartitionids().indexOf(partition);
        if(lastTimestep == -1) {
            timestep = getTimestep(nodeIndex, location);
        }
        else {
            timestep = lastTimestep;
        }

        Coordinate[] coordinates = new Coordinate[2];
        if(JSON_parser.isIndoor()){
            lat = location.getN();
            lon = location.getE();
            height = location.getD();
            coordinates[0] = new Coordinate(lat, lon, height);

            lat = dynamicGoto.getLocation().getLatitude();
            lon = dynamicGoto.getLocation().getLongitude();
            height = dynamicGoto.getLocation().getHeight();
            coordinates[1] = new Coordinate(lat, lon, height);

            newWaypoint = dynamicGoto.getLocation().getN().toString() + "," +
                    dynamicGoto.getLocation().getE().toString() + "," +
                    dynamicGoto.getLocation().getD().toString();
        }
        else{
            lat = location.getLatitude();
            lon = location.getLongitude();
            height = location.getHeight();
            coordinates[0] = new Coordinate(lat, lon, height);

            lat = dynamicGoto.getLocation().getLatitude();
            lon = dynamicGoto.getLocation().getLongitude();
            height = dynamicGoto.getLocation().getHeight();
            coordinates[1] = new Coordinate(lat, lon, height);

            newWaypoint = dynamicGoto.getLocation().getLatitude().toString() + "," +
                    dynamicGoto.getLocation().getLongitude().toString() + "," +
                    dynamicGoto.getLocation().getHeight();
        }
        /*check if new waypoint is inside the testbed area*/
        if(Database.inTestbedArea(JSON_parser.getTestbedID(), newWaypoint)){
            String[] coords = newWaypoint.split(",");
            lat = Double.parseDouble(coords[1]);
            lon = Double.parseDouble(coords[0]);
            GeometryFactory geometryFactory = new GeometryFactory();
            Point point = geometryFactory.createPoint(new Coordinate(lat, lon));
            LineString lineString = geometryFactory.createLineString(coordinates);

            for(Polygon obstacle : testbedObstacles){
                /* collision with testbed obstacle */
                if(obstacle.contains(point))
                    return false;
                /*check the path line from the current
                 * location towards the new waypoint*/
                if(lineString.crosses(obstacle))
                    return false;
            }

            /*check distance from each node at the next timestep*/
            return !checkDistance(newWaypoint, timestep + 1, nodeIndex);
        }

        return true;
    }


    private boolean checkDistance(String waypoint, int timestep, int nodeIndex)
    {
        double distance;
        String location;
        List<List<String>> paths;
        String[] locationCoordinates, waypointCoordinates;

        paths = JSON_parser.getPaths();
        waypointCoordinates = waypoint.split(",");

        /*if the relocation occurs at the
         * last waypoint of the initial path*/
        if(timestep == paths.get(nodeIndex).size()) {
            timestep -= 1;
        }
        for(int i = 0; i < paths.size(); i++){
            if(i == nodeIndex)
                continue;

            location = paths.get(i).get(timestep);
            locationCoordinates = location.split(",");

            if(JSON_parser.isIndoor()){

                NED nodeCoordinates = new NED(Double.parseDouble(locationCoordinates[0]),
                                              Double.parseDouble(locationCoordinates[1]),
                                              Double.parseDouble(locationCoordinates[2]));

                NED pointCoordinates = new NED(Double.parseDouble(waypointCoordinates[0]),
                                               Double.parseDouble(waypointCoordinates[1]),
                                               Double.parseDouble(waypointCoordinates[2]));

                distance = distance(nodeCoordinates, pointCoordinates);

            }
            else{

                WGS84 nodeCoordinates = new WGS84(Double.parseDouble(locationCoordinates[0]),
                                                  Double.parseDouble(locationCoordinates[1]),
                                                  Double.parseDouble(locationCoordinates[2]));

                WGS84 pointCoordinates = new WGS84(Double.parseDouble(waypointCoordinates[0]),
                                                   Double.parseDouble(waypointCoordinates[1]),
                                                   Double.parseDouble(waypointCoordinates[2]));

                distance = distance(nodeCoordinates, pointCoordinates);
            }

            /*too close, probable collision*/
            if(distance < minDistance)
                return true;
        }

        return false;
    }


    public String cameraActivation()
    {
        String url, response;
        StartRecordClient record;
        JSONObject cameraActivationJSON;
        List<String> devicesForCameraActivation;

        devicesForCameraActivation = JSON_parser.getDevicesForCameraActivation();
        if(devicesForCameraActivation.size() > 0){
            cameraActivationJSON = JSON_Generator.generateCameraActivation();

            //send json
            url = "http://195.134.67.223:4444/capture/start";
            record = new StartRecordClient(url, cameraActivationJSON.toString());
            response = record.sendMessage();

            return response;
        }

        return null;
    }

    public void cameraDeactivation(String message)
    {
        String stopService;
        StopRecordClient stopClient;

        stopService = "http://195.134.67.223:4444/capture/stop";
        stopClient = new StopRecordClient(stopService, message);
        stopClient.sendMessage();
    }
}
