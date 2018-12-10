package eu.rawfie.relocator.JSON;

import eu.rawfie.general.service.types.ExperimentChangeRequest;
import eu.rawfie.uxv.commands.DynamicGoto;
import eu.rawfie.uxv.commands.Goto;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class JSON_Generator {

    public static JSONObject generateExperimentChangeRequest(DynamicGoto dynamicGoto)
    {
        JSONObject jsonObject, header, location;

        header = new JSONObject();
        location = new JSONObject();
        jsonObject = new JSONObject();

        //set header
        header.element("sourceSystem", dynamicGoto.getHeader().getSourceSystem());
        header.element("sourceModule", dynamicGoto.getHeader().getSourceModule());
        header.element("time", dynamicGoto.getHeader().getTime());
        jsonObject.element("header", header);

        //set location
        location.element("latitude", dynamicGoto.getLocation().getLatitude());
        location.element("longitude", dynamicGoto.getLocation().getLongitude());
        location.element("height", dynamicGoto.getLocation().getHeight());
        location.element("n", dynamicGoto.getLocation().getN());
        location.element("e", dynamicGoto.getLocation().getE());
        location.element("d", dynamicGoto.getLocation().getD());
        location.element("depth", dynamicGoto.getLocation().getDepth());
        location.element("altitude", dynamicGoto.getLocation().getAltitude());
        jsonObject.element("location", location);

        jsonObject.element("speed", dynamicGoto.getSpeed());
        jsonObject.element("timeout", dynamicGoto.getTimeout());

        return jsonObject;
    }

    public static JSONObject generateScript(int timestep, DynamicGoto dynamicGoto, int partition)
    {
        JSONArray data = new JSONArray();
        JSONArray nodes = new JSONArray();
        JSONArray sensors = new JSONArray();
        JSONArray algorithms = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        for(int i = 0; i < JSON_parser.getResourceNames().size(); i++) {
            JSONObject node = new JSONObject();

            /* handling information from lists is done with indexes;
             * use partition to find the index of the node that is dynamically
             * reallocated and is required to add the new path to the script.*/
            if(i == JSON_parser.getPartitionids().indexOf(partition)){
                String newPath;
                if(JSON_parser.isIndoor()){
                    newPath = dynamicGoto.getLocation().getLatitude().toString() +
                            dynamicGoto.getLocation().getLongitude().toString()+
                            dynamicGoto.getLocation().getHeight().toString();
                }
                else{
                    newPath = dynamicGoto.getLocation().getN().toString() +
                            dynamicGoto.getLocation().getE().toString()+
                            dynamicGoto.getLocation().getD().toString();
                }
                node.element("nodeCommand", "goto");
                node.element("node", newPath);
                nodes.add(node);
            }
            else {
                node.element("nodeCommand", "goto");
                int lastTimestep = JSON_parser.getPaths().get(i).size() - 1;
                /*if the initial waypoints of a device are completed,
                * resend the last waypoint as long as new dynamic
                * waypoints arrive for another device*/
                if(lastTimestep < timestep){
                    node.element("node", JSON_parser.getPaths().get(i).get(lastTimestep));
                }
                else{
                    node.element("node", JSON_parser.getPaths().get(i).get(timestep));
                }
                nodes.add(node);
            }

            sensors.add(JSON_parser.getSensorsActDeact(i, timestep));
            algorithms.element((JSON_parser.getAlgorithms(timestep).getJSONObject(i)).get("algorithm"));
        }

        JSONArray location = new JSONArray();
        JSONObject timesteps = new JSONObject();
        timesteps.element("timestep", timestep);
        jsonObject.element("nodes", nodes);
        jsonObject.element("sensors", sensors);
        jsonObject.element("algorithms", algorithms);
        location.add(timesteps);
        location.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.element("location", location);
        data.add(jsonObject);

        JSONObject script = new JSONObject();
        script.element("data", data);
        script.element("nodeNames", JSON_parser.getNodeNames());
        script.element("nodeEvents", JSON_parser.getNodeEvents());
        script.element("Testbed", JSON_parser.getTestbed());
        script.element("TestbedArea", JSON_parser.getTestbedArea());

        return script;
    }


    public static JSONObject generateScript(String nodeName, int timestep, String condition, NodeEvent nodeEvent)
    {
        int i;
        List<String> waypoints;
        JSONArray location, data, nodes, nodenames, sensors;
        JSONObject jsonObject, timesteps, node, script, nodename, sensorsActDeact;

        data = new JSONArray();
        script = new JSONObject();
        nodenames = new JSONArray();
        nodename = new JSONObject();
        nodename.element("nodeName", nodeName);
        nodenames.add(nodename);
        waypoints = nodeEvent.getWaypoints(condition);

        /*waypoints for the alternative path of the specific node*/
        for(i = 0; i < waypoints.size(); i++){

            node = new JSONObject();
            nodes = new JSONArray();
            sensors = new JSONArray();
            location = new JSONArray();
            timesteps = new JSONObject();
            jsonObject = new JSONObject();

            timesteps.element("timestep", timestep + i);
            node.element("nodeCommand", "goto");
            node.element("node", waypoints.get(i));
            nodes.add(node);
            sensorsActDeact = JSON_parser.getSensorsActDeact(nodeName, timestep);
            sensors.add(sensorsActDeact);
            jsonObject.element("nodes", nodes);
            jsonObject.element("sensors", sensors);
            location.add(timesteps);
            location.add(jsonObject);
            jsonObject = new JSONObject();
            jsonObject.element("location", location);
            data.add(jsonObject);
        }

        /*add node command after the alternative path*/
        node = new JSONObject();
        nodes = new JSONArray();
        sensors = new JSONArray();
        location = new JSONArray();
        timesteps = new JSONObject();
        jsonObject = new JSONObject();

        timesteps.element("timestep", timestep + i);
        node.element("nodeCommand", nodeEvent.getCommand());
        node.element("node", "");
        nodes.add(node);
        sensorsActDeact = JSON_parser.getSensorsActDeact(nodeName, timestep);
        sensors.add(sensorsActDeact);
        jsonObject.element("nodes", nodes);
        jsonObject.element("sensors", sensors);
        location.add(timesteps);
        location.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.element("location", location);
        data.add(jsonObject);

        script.element("data", data);
        script.element("nodeNames", nodenames);
        script.element("nodeEvents", JSON_parser.getNodeEvents());
        script.element("Testbed", JSON_parser.getTestbed());
        script.element("TestbedArea", JSON_parser.getTestbedArea());

        return script;
    }

    public static ExperimentChangeRequest generateExperimentChangeRequest(String script, boolean dynamicNavigation)
    {
       /* JSONObject experimentChangeRequest, takeOffHeights;

        takeOffHeights = new JSONObject();
        experimentChangeRequest = new JSONObject();

        experimentChangeRequest.element("executionId", JSON_parser.getExecutionId());
        experimentChangeRequest.element("script", script);
        experimentChangeRequest.element("testbedId", JSON_parser.getTestbedID());
        experimentChangeRequest.element("isIndoor", JSON_parser.isIndoor());
        experimentChangeRequest.element("resourceNames", JSON_parser.getResourceNames());
        experimentChangeRequest.element("partitionids", JSON_parser.getPartitionids());
        experimentChangeRequest.element("accuracy", JSON_parser.getAccuracy());
        takeOffHeights.element("array", JSON_parser.getTakeOffHeights());
        experimentChangeRequest.element("takeOffHeights", takeOffHeights);
        experimentChangeRequest.element("dynamicNavigation", dynamicNavigation);*/


		ExperimentChangeRequest experimentChangeRequest = new ExperimentChangeRequest(String.valueOf(JSON_parser.getExecutionId()),
				script, JSON_parser.getTestbedID(), JSON_parser.isIndoor(),  JSON_parser.getResourceNames(),
				JSON_parser.getPartitionids(), JSON_parser.getAccuracy(), JSON_parser.getTakeOffHeights(),dynamicNavigation);


        return experimentChangeRequest;
    }

    public static JSONObject generateCameraActivation()
    {
        JSONObject cameraActivationJSON;

        cameraActivationJSON = new JSONObject();
        cameraActivationJSON.element("executionId", JSON_parser.getExecutionId());
        cameraActivationJSON.element("testbed_id", JSON_parser.getTestbedID());
        cameraActivationJSON.element("device_ids", JSON_parser.getDevicesForCameraActivation());

        return cameraActivationJSON;
    }
}
