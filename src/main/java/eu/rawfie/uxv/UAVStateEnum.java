/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.uxv;
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public enum UAVStateEnum {
  DISARMED, ARMED, MISSION_READY, STOPPED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"UAVStateEnum\",\"namespace\":\"eu.rawfie.uxv\",\"symbols\":[\"DISARMED\",\"ARMED\",\"MISSION_READY\",\"STOPPED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}