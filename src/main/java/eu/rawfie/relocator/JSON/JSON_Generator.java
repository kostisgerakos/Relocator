package eu.rawfie.relocator.JSON;

import eu.rawfie.uxv.commands.DynamicGoto;
import eu.rawfie.uxv.commands.Goto;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class JSON_Generator {

    public static JSONObject generateGoto(DynamicGoto dynamicGoto)
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
        script.element("Testbed", JSON_parser.getTestbed());
        script.element("TestbedArea", JSON_parser.getTestbedArea());

        return script;
    }

    public static JSONObject generateExperimentChangeRequest(String script)
    {
        JSONObject experimentChangeRequest, takeOffHeights;

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
        experimentChangeRequest.element("dynamicNavigation", true);

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
