/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.uxv;
@SuppressWarnings("all")
/** System type */
@org.apache.avro.specific.AvroGenerated
public enum SystemType {
  UUV, USV, UGV, UAV, FIXED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"SystemType\",\"namespace\":\"eu.rawfie.uxv\",\"doc\":\"System type\",\"symbols\":[\"UUV\",\"USV\",\"UGV\",\"UAV\",\"FIXED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}