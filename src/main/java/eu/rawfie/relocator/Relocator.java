package eu.rawfie.relocator;

import eu.rawfie.relocator.JSON.JSON_Generator;
import eu.rawfie.relocator.JSON.JSON_parser;
import eu.rawfie.relocator.JSON.NodeEvent;
import eu.rawfie.relocator.REST.StartRecordClient;
import eu.rawfie.relocator.REST.StopRecordClient;
import eu.rawfie.relocator.coordinates.*;
import eu.rawfie.uxv.Header;
import eu.rawfie.uxv.Location;
import eu.rawfie.uxv.commands.DynamicGoto;
import net.sf.json.JSONObject;

import java.util.List;

public class Relocator {

    private int lastTimestep;
    private double minDistance;

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

        for (int j = 0; j < newWaypoints.size(); j++){

            /*check if new waypoint is inside the testbed area*/
//            if(!Database.inTestbedArea(JSON_parser.getTestbedID(), newWaypoints.get(j)))
//                return false;

            /*check distance from each node at the next timestep*/
            if (checkDistance(newWaypoints.get(j), timestep + j + 1, nodeIndex))
                return false;
        }

        script = JSON_Generator.generateScript(nodeName, timestep+1, condition, nodeEvent).toString();
        //JSONObject experimentChangeRequest = JSON_Generator.generateExperimentChangeRequest(script, false);
        //TODO producer to post experimentChangeRequest to RC
        
        
        //System.out.println(experimentChangeRequest);
        return true;
    }

    public boolean validateAlternativePath(DynamicGoto dynamicGoto, int partition)
    {
        String newWaypoint;
        int timestep, nodeIndex;


        /*the current location of the node that sent the request for the alternative path*/
        //TODO consume location of device here
        Location currentLocation = new Location(new Header("test","test",(long) 1000000000),10.0, 20.0, 30.0f,
                0.0, 0.0, 0.0, 0.0f, 0.0f);

        nodeIndex = JSON_parser.getPartitionids().indexOf(partition);
        timestep = getTimestep(nodeIndex, currentLocation);

        if(JSON_parser.isIndoor()){
            newWaypoint = dynamicGoto.getLocation().getN().toString() + "," +
                          dynamicGoto.getLocation().getE().toString() + "," +
                          dynamicGoto.getLocation().getD().toString();
        }
        else{
            newWaypoint = dynamicGoto.getLocation().getLatitude().toString() + "," +
                          dynamicGoto.getLocation().getLongitude().toString() + "," +
                          dynamicGoto.getLocation().getHeight();
        }
        /*check if new waypoint is inside the testbed area*/
//      if(!Database.inTestbedArea(JSON_parser.getTestbedID(), newWaypoints.get(j)))
//          return false;

        /*check distance from each node at the next timestep*/
        if (checkDistance(newWaypoint, timestep + 1, nodeIndex))
            return false;

        return true;
    }
    
    public void navigateDevices()
    {
    //TODO producer to post Goto command to the device
    	JSONObject newGoto = JSON_Generator.generateExperimentChangeRequest(JSON_parser.getDynamicGoto());
    	System.out.println("new goto" + newGoto);

    }

    private boolean checkDistance(String waypoint, int timestep, int nodeIndex)
    {
        double distance;
        String location;
        List<List<String>> paths;
        String[] locationCoordinates, waypointCoordinates;

        paths = JSON_parser.getPaths();
        waypointCoordinates = waypoint.split(",");

        for(int i = 0; i < paths.size(); i++){
            if(i == nodeIndex)
                continue;

            /*if the relocation occurs at the
             * last waypoint of the initial path*/
            if(timestep == paths.get(i).size()) {
                timestep -= 1;
            }
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



//    public void cameraActivation() throws InterruptedException
//    {
//        String url, stopService;
//        JSONObject cameraActivationJSON;
//        List<String> devicesForCameraActivation;
//
//        devicesForCameraActivation = json_parser.getDevicesForCameraActivation();
//        if(devicesForCameraActivation.size() > 0){
//            cameraActivationJSON = json_generator.generateCameraActivation();
//
//            //send json
//            url = "http://195.134.67.223:4444/capture/start";
//            stopService = "http://195.134.67.223:4444/capture/stop";
//            StartRecordClient record = new StartRecordClient(url, cameraActivationJSON.toString(), stopService);
//            Thread.sleep(10000);
//            record.getStopClient().sendMessage();
//        }
//    }

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
