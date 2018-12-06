package eu.rawfie.relocator;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;

import eu.rawfie.relocator.database.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Geofencing {

    private Polygon testbedPolygon;

    public Geofencing(String testbedID)
    {
        String testbedArea = Database.getTestbedAreaPolygon(testbedID);
        StringBuilder finalCoords = new StringBuilder("");
        String [] strs = testbedArea.substring(1, testbedArea.length() - 1).split("\\),");

        for(String str: strs){
            str = str.replace("(", "");
            str = str.replace(",", " ");
            finalCoords.append(str).append(", ");
        }
        /*remove last 2 character, because they
         are a comma and a left parenthesis*/
        finalCoords.setLength(finalCoords.length() - 3);
        strs = finalCoords.toString().split(", ");
        List<String> transformedPolygon = new ArrayList<>(Arrays.asList(strs));

        /*create testbed polygon*/
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate[] coordinates = new Coordinate[transformedPolygon.size()];

        for (int i = 0; i < transformedPolygon.size(); i++) {
            strs = transformedPolygon.get(i).split(" ");
            coordinates[i] = new Coordinate(Double.parseDouble(strs[0]), Double.parseDouble(strs[1]));
        }

        this.testbedPolygon = geometryFactory.createPolygon(coordinates);
    }

    public boolean inTestbedArea(String waypoint)
    {
        double lat, lon;
        String[] coords = waypoint.split(",");
        lat = Double.parseDouble(coords[1]);
        lon = Double.parseDouble(coords[0]);
        GeometryFactory geometryFactory = new GeometryFactory();

        return testbedPolygon.contains(geometryFactory.createPoint(new Coordinate(lat, lon)));
    }

    public boolean inTestbedArea(double lat, double lon)
    {
        GeometryFactory geometryFactory = new GeometryFactory();
        return testbedPolygon.contains(geometryFactory.createPoint(new Coordinate(lat, lon)));
    }
}
