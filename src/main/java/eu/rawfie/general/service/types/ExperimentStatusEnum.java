/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.general.service.types;
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public enum ExperimentStatusEnum {
  BOOKED, ONGOING, CHANGED, COMPLETED, BLOCKED, CANCELED, FAILED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"ExperimentStatusEnum\",\"namespace\":\"eu.rawfie.general.service.types\",\"symbols\":[\"BOOKED\",\"ONGOING\",\"CHANGED\",\"COMPLETED\",\"BLOCKED\",\"CANCELED\",\"FAILED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}