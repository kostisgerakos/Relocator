package eu.rawfie.relocator.JSON;

import eu.rawfie.general.service.types.ExperimentStartRequest;
import eu.rawfie.relocator.database.Database;
import eu.rawfie.uxv.Header;
import eu.rawfie.uxv.Location;
import eu.rawfie.uxv.commands.DynamicGoto;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.math.BigDecimal;

import java.util.*;

public class JSON_parser {

    //first dimension: devices,
    //second dimension: timesteps
    private static List<List<String>> paths;
//    private static List<List<String>> algorithms;
    private static Map<String, NodeEvent> eventsMap;
    private static Map<Integer, String> partitionMap;
    private static List<List<JSONObject>> sensorsActDeact;
    private static List<String> devicesForCameraActivation;
    private static ExperimentStartRequest experimentStartRequest;
    private static DynamicGoto dynamicGoto; 

    public static void init_JSON_parser()
    {
        dynamicGoto = new DynamicGoto();
        paths = new ArrayList<>();
        eventsMap = new HashMap<>();
//        algorithms = new ArrayList<>();
        partitionMap = new HashMap<>();
        sensorsActDeact = new ArrayList<>();
        devicesForCameraActivation = new ArrayList<>();
        experimentStartRequest = new ExperimentStartRequest();
    }

    //make it also handle multiple requests (map)
    public static void parseDynamicGoto(String request)
    {
        JSONObject jsonObject = JSONObject.fromObject(request);

        //parse header
        Long time = jsonObject.getJSONObject("header").getLong("time");
        String sourceSystem = jsonObject.getJSONObject("header").getString("sourceSystem");
        String sourceModule = jsonObject.getJSONObject("header").getString("sourceModule");
        Header header = new Header(sourceSystem, sourceModule, time);

        //parse coordinates
        Double latitude  = jsonObject.getJSONObject("location").getDouble("latitude");
        Double longitude = jsonObject.getJSONObject("location").getDouble("longitude");
        Float height = BigDecimal.valueOf(jsonObject.getJSONObject("location").getDouble("height")).floatValue();
        Double n = jsonObject.getJSONObject("location").getDouble("n");
        Double e = jsonObject.getJSONObject("location").getDouble("e");
        Double d = jsonObject.getJSONObject("location").getDouble("d");
        Float depth = BigDecimal.valueOf(jsonObject.getJSONObject("location").getDouble("depth")).floatValue();
        Float altitude = BigDecimal.valueOf(jsonObject.getJSONObject("location").getDouble("altitude")).floatValue();
        Location location = new Location(header,latitude, longitude, height, n, e, d, depth, altitude);

        //parse speed
        Float speed = BigDecimal.valueOf(jsonObject.getDouble("speed")).floatValue();

        //parse timeout
        Float timeout = BigDecimal.valueOf(jsonObject.getDouble("timeout")).floatValue();

        dynamicGoto.setHeader(header);  
        dynamicGoto.setLocation(location);
        dynamicGoto.setSpeed(speed);
        dynamicGoto.setTimeout(timeout);
    }

    public static void parseExperimentStartRequest(String request)
    {
        JSONObject jsonObject = JSONObject.fromObject(request);

        experimentStartRequest.setAccuracy(jsonObject.getDouble("accuracy"));
        experimentStartRequest.setIsIndoor(jsonObject.getBoolean("isIndoor"));
        experimentStartRequest.setTestbedId(jsonObject.getString("testbedId"));
        experimentStartRequest.setPartitionids(jsonObject.getJSONArray("partitionids"));
        experimentStartRequest.setResourceNames(jsonObject.getJSONArray("resourceNames"));
        experimentStartRequest.setScript(jsonObject.getString("script"));
        experimentStartRequest.setExecutionId(jsonObject.getString("executionId"));
        experimentStartRequest.setTakeOffHeights(jsonObject.getJSONArray("takeOffHeights"));

        parseEvents();
        parseScript();
        //setPartitions();
        //setPartitionMap();
    }

    private static void setPartitions()
    {
        NodeEvent nodeEvent;
        List<Integer> partitions = getPartitionids();
        List<String> resourceNames = getResourceNames();
        for(int i = 0; i < partitions.size(); i++){
            nodeEvent = eventsMap.get(resourceNames.get(i).toString());
            nodeEvent.setPartition(partitions.get(i));
        }
    }

    /*device name to partition mapping*/
    private static void setPartitionMap()
    {
        List<Integer> partitions = getPartitionids();
        List<String> resourceNames = getResourceNames();
        for(int i = 0; i < partitions.size(); i++){
            partitionMap.put(partitions.get(i), resourceNames.get(i).toString());
        }
    }

    private static void parseEvents()
    {
        JSONArray events;
        NodeEvent nodeEvent;
        List<String> alternativePath;
        String[] conditionAndcommands;
        String event, nodeName, condition, command;

        events = getNodeEvents();
        for (Object event1 : events) {

            event = ((JSONObject) event1).get("nodeEvent").toString();
            nodeName  = event.split("!")[0];
            conditionAndcommands = (event.split("!")[1]).split("/");

            condition = conditionAndcommands[0].split("/")[0];
            command   = conditionAndcommands[1].split("#")[1];
            alternativePath = Arrays.asList(conditionAndcommands[1].split("#")[0].split("@"));

            if(!eventsMap.containsKey(nodeName)){
                eventsMap.put(nodeName, new NodeEvent());
            }

           nodeEvent = eventsMap.get(nodeName);
           nodeEvent.setCommand(command);
           nodeEvent.setNodeName(nodeName);
           nodeEvent.setSensors(Database.getSensors(nodeName));
           nodeEvent.addConditionAndWaypoints(condition, alternativePath);
        }
    }

    private static void parseScript()
    {

        JSONArray data, nodes, sensorsActDeactArray, algorithms;
        JSONObject sensorsActDeact;
        String waypoints, algorithm;

        for(int i = 0; i <experimentStartRequest.getResourceNames().size(); i++) {
            paths.add(new ArrayList<>());
//            JSON_parser.algorithms.add(new ArrayList<>());
            JSON_parser.sensorsActDeact.add(new ArrayList<>());
        }

        data = getScriptData();
        for (int timestep = 0; timestep < data.size(); timestep++) {
            nodes = ((data.getJSONObject(timestep)).getJSONArray("location"))
                    .getJSONObject(1).getJSONArray("nodes");
//            algorithms = ((data.getJSONObject(timestep)).getJSONArray("location"))
//                    .getJSONObject(1).getJSONArray("algorithms");
            sensorsActDeactArray = ((data.getJSONObject(timestep)).getJSONArray("location"))
                    .getJSONObject(1).getJSONArray("sensors");

            for(int i = 0; i < nodes.size(); i++){
                waypoints = nodes.getJSONObject(i).get("node").toString();
                paths.get(i).add(waypoints);
                sensorsActDeact = sensorsActDeactArray.getJSONObject(i);
                JSON_parser.sensorsActDeact.get(i).add(sensorsActDeact);

                if(sensorsActDeact.getString("sensorsActDeact").contains("CameraImage")){
                    devicesForCameraActivation.add(getResourceNames().get(i).toString());
                }

//                algorithm = (algorithms.getJSONObject(i)).get("algorithm").toString();
//                JSON_parser.algorithms.get(i).add(algorithm);
            }
        }
    }

    public static JSONObject getSensorsActDeact(String nodeName, int timestep)
    {
        int nodeIndex;
        JSONObject sensorsAD;

        nodeIndex = getResourceNames().indexOf(nodeName);
        sensorsAD = sensorsActDeact.get(nodeIndex).get(timestep);

        return sensorsAD;
    }

    public static String getTestbed()
    {
        JSONObject script = JSONObject.fromObject(experimentStartRequest.getScript());
        return script.getString("Testbed");
    }

    public static String getTestbedArea()
    {
        JSONObject script = JSONObject.fromObject(experimentStartRequest.getScript());
        return script.getString("TestbedArea");
    }

    public static DynamicGoto getDynamicGoto() { return dynamicGoto; }
    public static List<List<String>> getPaths(){ return paths; }
    public static Map<String, NodeEvent> getEventsMap() { return eventsMap; }
    public static Map<Integer, String> getPartitionMap(){ return partitionMap; }
    public static boolean isIndoor() { return experimentStartRequest.getIsIndoor(); }
    public static double getAccuracy(){ return experimentStartRequest.getAccuracy(); }
    public static String getTestbedID() { return experimentStartRequest.getTestbedId().toString(); }
    public static List<Integer> getPartitionids(){ return experimentStartRequest.getPartitionids(); }
    public static List<String> getDevicesForCameraActivation(){ return  devicesForCameraActivation; }
    public static List<Double> getTakeOffHeights(){ return experimentStartRequest.getTakeOffHeights(); }
    public static List<String> getResourceNames() { return experimentStartRequest.getResourceNames(); }
    public static int getExecutionId(){ return Integer.parseInt(experimentStartRequest.getExecutionId().toString()); }
    public static JSONArray getScriptData() { return JSONObject.fromObject(experimentStartRequest.getScript()).getJSONArray("data"); }
    private static JSONArray getNodeEvents() { return JSONObject.fromObject(experimentStartRequest.getScript()).getJSONArray("nodeEvents"); }


}
