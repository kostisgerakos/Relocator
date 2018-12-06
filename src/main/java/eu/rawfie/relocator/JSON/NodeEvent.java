package eu.rawfie.relocator.JSON;

import java.util.*;

public class NodeEvent {

    private int partition;
    private String command;
    private String nodeName;
    private List<String> sensors;
    private Map<String, List<String>> conditionAndWaypoints;

    public NodeEvent() { this.conditionAndWaypoints = new HashMap<>(); }

    public void setCommand(String command)
    {
        this.command = command;
    }
    public void setNodeName(String nodeName) { this.nodeName = nodeName; }
    public void setPartition(int partition)
    {
        this.partition = partition;
    }
    public void setSensors(List<String> sensors) { this.sensors = sensors; }
    public void addConditionAndWaypoints(String condition, List<String> waypoints) {
        this.conditionAndWaypoints.put(condition, waypoints); }

    public String getCommand() { return command; }
    public int getPartition()
    {
        return partition;
    }
    public String getNodeName() { return nodeName; }
    public List<String> getSensors() { return sensors; }
    public Set<String> getConditions(){
        return conditionAndWaypoints.keySet();
    }
    public Map<String, List<String>> getConditionAndWaypoints() {
        return conditionAndWaypoints;
    }
    public List<String> getWaypoints(String condition)
    {
        return conditionAndWaypoints.get(condition);
    }
}
