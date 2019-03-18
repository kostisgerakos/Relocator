package eu.rawfie.relocator.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Connection establishConnection()
    {
        try {
            String password = "";
            String username = "postgres";
            String db_url = "jdbc:postgresql://172.19.0.6:5432/rawfie_db";

            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(db_url, username, password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean inTestbedArea(String testbedID, String coordinates)
    {
        String query, coords[];
        ResultSet results = null;
        Connection connection = null;
        PreparedStatement statement = null;

        coords = coordinates.split(",");
        try {
            connection = establishConnection();

            query = "select ST_Contains(ST_Polygon(ST_GeomFromText('LINESTRING('||?||')', 4326), 4326)," +
                    "ST_SetSRID(ST_MakePoint(?, ?, ?), 4326))";

            assert connection != null;
            statement = connection.prepareStatement(query);
            statement.setString(1, testbedID);
            statement.setDouble(2, Double.parseDouble(coords[1]));
            statement.setDouble(3, Double.parseDouble(coords[0]));
            statement.setDouble(4, Double.parseDouble(coords[2]));
            results = statement.executeQuery();

            while(results.next()){
                if( results.getString(1).equals("f") ){
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {

            closeConnection(connection, statement, results);
        }

        return true;
    }

    public static String getTestbedAreaPolygon(String testbedID)
    {
        String query, polygon = null;
        ResultSet results = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = establishConnection();

            query = "select area_validation from public.testbed_area where testbed_id = ?";
            assert connection != null;
            statement = connection.prepareStatement(query);
            statement.setString(1, testbedID);
            results = statement.executeQuery();

            while(results.next()) {
                polygon = results.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection(connection, statement, results);
        }

        return polygon;
    }

    public static String getTestbedObstacles(String testbedArea)
    {
        String query, polygon = null;
        ResultSet results = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = establishConnection();

            query = "select obstacles_validation from public.testbed_area where name = ?";
            assert connection != null;
            statement = connection.prepareStatement(query);
            statement.setString(1, testbedArea);
            results = statement.executeQuery();

            while(results.next()) {
                polygon = results.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection(connection, statement, results);
        }

        return polygon;
    }

    public static List<String> getSensors(String nodeName)
    {
        List<String> sensors = new ArrayList<>();

        String query;
        ResultSet results = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = establishConnection();

            query = "select sensor_name from public.sensor where resource_id = (select resource_id from public.resource where resource_name = ?)";
            assert connection != null;
            statement = connection.prepareStatement(query);
            statement.setString(1, nodeName);
            results = statement.executeQuery();

            while(results.next()){
                sensors.add(results.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            closeConnection(connection, statement, results);
        }

        return sensors;
    }

    private static void closeConnection(Connection connection, PreparedStatement statement, ResultSet rs)
    {
        try {
            if(rs != null)
                rs.close();

            if(statement != null)
                statement.close();

            if(connection != null)
                connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
