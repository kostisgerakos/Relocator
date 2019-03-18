package eu.rawfie.relocator;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import eu.rawfie.relocator.JSON.JSON_parser;
import eu.rawfie.relocator.database.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Geofencing {

    private Polygon testbedPolygon;
    private Polygon[] testbedObstacles;

    public Geofencing(String testbedID)
    {
        /*create testbed area polygon*/
        String testbedArea = Database.getTestbedAreaPolygon(testbedID);
        List<String> transformedPoints = tranformPoints(testbedArea);

        /*create testbed polygon*/
        GeometryFactory geometryFactory = new GeometryFactory();
        this.testbedPolygon = createPolygon(geometryFactory, transformedPoints);

        /*create testbed obstacles polygons*/
        String obstaclesStr = Database.getTestbedObstacles(JSON_parser.getTestbedArea());
        if ( obstaclesStr == null )
            return;

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


    public boolean inTestbedArea(String waypoint)
    {
        double lat, lon;
        String[] coords = waypoint.split(",");
        lat = Double.parseDouble(coords[1]);
        lon = Double.parseDouble(coords[0]);
        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(new Coordinate(lat, lon));

        if(testbedPolygon.contains(point)){
            for(Polygon obstacle : testbedObstacles){
                /*some obstacle is hit */
                if(obstacle.contains(geometryFactory.createPoint(new Coordinate(lat, lon))))
                    return false;
            }

            return true;
        }

        return false;
    }

    public boolean inTestbedArea(double lat, double lon)
    {
        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(new Coordinate(lat, lon));

        if(testbedPolygon.contains(point)){
            for(Polygon obstacle : testbedObstacles){
                /*some obstacle is hit */
                if(obstacle.contains(geometryFactory.createPoint(new Coordinate(lat, lon))))
                    return false;
            }
            return true;
        }

        return false;
    }
}
