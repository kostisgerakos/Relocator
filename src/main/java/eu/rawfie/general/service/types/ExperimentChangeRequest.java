/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.general.service.types;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ExperimentChangeRequest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1912731148516738857L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ExperimentChangeRequest\",\"namespace\":\"eu.rawfie.general.service.types\",\"fields\":[{\"name\":\"executionId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"script\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"testbedId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"isIndoor\",\"type\":\"boolean\",\"default\":false},{\"name\":\"resourceNames\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"partitionids\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"accuracy\",\"type\":\"double\",\"doc\":\"Desired accuracy for the waypoint-navigation procedure\",\"unit\":\"m\"},{\"name\":\"takeOffHeights\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"double\"}],\"doc\":\"Desired take off height - For UAVs only\",\"default\":null,\"unit\":\"m\"},{\"name\":\"dynamicNavigation\",\"type\":\"boolean\",\"default\":false}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   public java.lang.String executionId;
   public java.lang.String script;
   public java.lang.String testbedId;
   public boolean isIndoor;
   public java.util.List<java.lang.String> resourceNames;
   public java.util.List<java.lang.Integer> partitionids;
  /** Desired accuracy for the waypoint-navigation procedure */
   public double accuracy;
  /** Desired take off height - For UAVs only */
   public java.util.List<java.lang.Double> takeOffHeights;
   public boolean dynamicNavigation;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ExperimentChangeRequest() {}

  /**
   * All-args constructor.
   * @param executionId The new value for executionId
   * @param script The new value for script
   * @param testbedId The new value for testbedId
   * @param isIndoor The new value for isIndoor
   * @param resourceNames The new value for resourceNames
   * @param partitionids The new value for partitionids
   * @param accuracy Desired accuracy for the waypoint-navigation procedure
   * @param takeOffHeights Desired take off height - For UAVs only
   * @param dynamicNavigation The new value for dynamicNavigation
   */
  public ExperimentChangeRequest(java.lang.String executionId, java.lang.String script, java.lang.String testbedId, java.lang.Boolean isIndoor, java.util.List<java.lang.String> resourceNames, java.util.List<java.lang.Integer> partitionids, java.lang.Double accuracy, java.util.List<java.lang.Double> takeOffHeights, java.lang.Boolean dynamicNavigation) {
    this.executionId = executionId;
    this.script = script;
    this.testbedId = testbedId;
    this.isIndoor = isIndoor;
    this.resourceNames = resourceNames;
    this.partitionids = partitionids;
    this.accuracy = accuracy;
    this.takeOffHeights = takeOffHeights;
    this.dynamicNavigation = dynamicNavigation;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return executionId;
    case 1: return script;
    case 2: return testbedId;
    case 3: return isIndoor;
    case 4: return resourceNames;
    case 5: return partitionids;
    case 6: return accuracy;
    case 7: return takeOffHeights;
    case 8: return dynamicNavigation;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: executionId = (java.lang.String)value$; break;
    case 1: script = (java.lang.String)value$; break;
    case 2: testbedId = (java.lang.String)value$; break;
    case 3: isIndoor = (java.lang.Boolean)value$; break;
    case 4: resourceNames = (java.util.List<java.lang.String>)value$; break;
    case 5: partitionids = (java.util.List<java.lang.Integer>)value$; break;
    case 6: accuracy = (java.lang.Double)value$; break;
    case 7: takeOffHeights = (java.util.List<java.lang.Double>)value$; break;
    case 8: dynamicNavigation = (java.lang.Boolean)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'executionId' field.
   * @return The value of the 'executionId' field.
   */
  public java.lang.String getExecutionId() {
    return executionId;
  }

  /**
   * Sets the value of the 'executionId' field.
   * @param value the value to set.
   */
  public void setExecutionId(java.lang.String value) {
    this.executionId = value;
  }

  /**
   * Gets the value of the 'script' field.
   * @return The value of the 'script' field.
   */
  public java.lang.String getScript() {
    return script;
  }

  /**
   * Sets the value of the 'script' field.
   * @param value the value to set.
   */
  public void setScript(java.lang.String value) {
    this.script = value;
  }

  /**
   * Gets the value of the 'testbedId' field.
   * @return The value of the 'testbedId' field.
   */
  public java.lang.String getTestbedId() {
    return testbedId;
  }

  /**
   * Sets the value of the 'testbedId' field.
   * @param value the value to set.
   */
  public void setTestbedId(java.lang.String value) {
    this.testbedId = value;
  }

  /**
   * Gets the value of the 'isIndoor' field.
   * @return The value of the 'isIndoor' field.
   */
  public java.lang.Boolean getIsIndoor() {
    return isIndoor;
  }

  /**
   * Sets the value of the 'isIndoor' field.
   * @param value the value to set.
   */
  public void setIsIndoor(java.lang.Boolean value) {
    this.isIndoor = value;
  }

  /**
   * Gets the value of the 'resourceNames' field.
   * @return The value of the 'resourceNames' field.
   */
  public java.util.List<java.lang.String> getResourceNames() {
    return resourceNames;
  }

  /**
   * Sets the value of the 'resourceNames' field.
   * @param value the value to set.
   */
  public void setResourceNames(java.util.List<java.lang.String> value) {
    this.resourceNames = value;
  }

  /**
   * Gets the value of the 'partitionids' field.
   * @return The value of the 'partitionids' field.
   */
  public java.util.List<java.lang.Integer> getPartitionids() {
    return partitionids;
  }

  /**
   * Sets the value of the 'partitionids' field.
   * @param value the value to set.
   */
  public void setPartitionids(java.util.List<java.lang.Integer> value) {
    this.partitionids = value;
  }

  /**
   * Gets the value of the 'accuracy' field.
   * @return Desired accuracy for the waypoint-navigation procedure
   */
  public java.lang.Double getAccuracy() {
    return accuracy;
  }

  /**
   * Sets the value of the 'accuracy' field.
   * Desired accuracy for the waypoint-navigation procedure
   * @param value the value to set.
   */
  public void setAccuracy(java.lang.Double value) {
    this.accuracy = value;
  }

  /**
   * Gets the value of the 'takeOffHeights' field.
   * @return Desired take off height - For UAVs only
   */
  public java.util.List<java.lang.Double> getTakeOffHeights() {
    return takeOffHeights;
  }

  /**
   * Sets the value of the 'takeOffHeights' field.
   * Desired take off height - For UAVs only
   * @param value the value to set.
   */
  public void setTakeOffHeights(java.util.List<java.lang.Double> value) {
    this.takeOffHeights = value;
  }

  /**
   * Gets the value of the 'dynamicNavigation' field.
   * @return The value of the 'dynamicNavigation' field.
   */
  public java.lang.Boolean getDynamicNavigation() {
    return dynamicNavigation;
  }

  /**
   * Sets the value of the 'dynamicNavigation' field.
   * @param value the value to set.
   */
  public void setDynamicNavigation(java.lang.Boolean value) {
    this.dynamicNavigation = value;
  }

  /**
   * Creates a new ExperimentChangeRequest RecordBuilder.
   * @return A new ExperimentChangeRequest RecordBuilder
   */
  public static eu.rawfie.general.service.types.ExperimentChangeRequest.Builder newBuilder() {
    return new eu.rawfie.general.service.types.ExperimentChangeRequest.Builder();
  }

  /**
   * Creates a new ExperimentChangeRequest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ExperimentChangeRequest RecordBuilder
   */
  public static eu.rawfie.general.service.types.ExperimentChangeRequest.Builder newBuilder(eu.rawfie.general.service.types.ExperimentChangeRequest.Builder other) {
    return new eu.rawfie.general.service.types.ExperimentChangeRequest.Builder(other);
  }

  /**
   * Creates a new ExperimentChangeRequest RecordBuilder by copying an existing ExperimentChangeRequest instance.
   * @param other The existing instance to copy.
   * @return A new ExperimentChangeRequest RecordBuilder
   */
  public static eu.rawfie.general.service.types.ExperimentChangeRequest.Builder newBuilder(eu.rawfie.general.service.types.ExperimentChangeRequest other) {
    return new eu.rawfie.general.service.types.ExperimentChangeRequest.Builder(other);
  }

  /**
   * RecordBuilder for ExperimentChangeRequest instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ExperimentChangeRequest>
    implements org.apache.avro.data.RecordBuilder<ExperimentChangeRequest> {

    private java.lang.String executionId;
    private java.lang.String script;
    private java.lang.String testbedId;
    private boolean isIndoor;
    private java.util.List<java.lang.String> resourceNames;
    private java.util.List<java.lang.Integer> partitionids;
    /** Desired accuracy for the waypoint-navigation procedure */
    private double accuracy;
    /** Desired take off height - For UAVs only */
    private java.util.List<java.lang.Double> takeOffHeights;
    private boolean dynamicNavigation;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(eu.rawfie.general.service.types.ExperimentChangeRequest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.executionId)) {
        this.executionId = data().deepCopy(fields()[0].schema(), other.executionId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.script)) {
        this.script = data().deepCopy(fields()[1].schema(), other.script);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.testbedId)) {
        this.testbedId = data().deepCopy(fields()[2].schema(), other.testbedId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.isIndoor)) {
        this.isIndoor = data().deepCopy(fields()[3].schema(), other.isIndoor);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.resourceNames)) {
        this.resourceNames = data().deepCopy(fields()[4].schema(), other.resourceNames);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.partitionids)) {
        this.partitionids = data().deepCopy(fields()[5].schema(), other.partitionids);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.accuracy)) {
        this.accuracy = data().deepCopy(fields()[6].schema(), other.accuracy);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.takeOffHeights)) {
        this.takeOffHeights = data().deepCopy(fields()[7].schema(), other.takeOffHeights);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.dynamicNavigation)) {
        this.dynamicNavigation = data().deepCopy(fields()[8].schema(), other.dynamicNavigation);
        fieldSetFlags()[8] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ExperimentChangeRequest instance
     * @param other The existing instance to copy.
     */
    private Builder(eu.rawfie.general.service.types.ExperimentChangeRequest other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.executionId)) {
        this.executionId = data().deepCopy(fields()[0].schema(), other.executionId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.script)) {
        this.script = data().deepCopy(fields()[1].schema(), other.script);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.testbedId)) {
        this.testbedId = data().deepCopy(fields()[2].schema(), other.testbedId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.isIndoor)) {
        this.isIndoor = data().deepCopy(fields()[3].schema(), other.isIndoor);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.resourceNames)) {
        this.resourceNames = data().deepCopy(fields()[4].schema(), other.resourceNames);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.partitionids)) {
        this.partitionids = data().deepCopy(fields()[5].schema(), other.partitionids);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.accuracy)) {
        this.accuracy = data().deepCopy(fields()[6].schema(), other.accuracy);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.takeOffHeights)) {
        this.takeOffHeights = data().deepCopy(fields()[7].schema(), other.takeOffHeights);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.dynamicNavigation)) {
        this.dynamicNavigation = data().deepCopy(fields()[8].schema(), other.dynamicNavigation);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'executionId' field.
      * @return The value.
      */
    public java.lang.String getExecutionId() {
      return executionId;
    }

    /**
      * Sets the value of the 'executionId' field.
      * @param value The value of 'executionId'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder setExecutionId(java.lang.String value) {
      validate(fields()[0], value);
      this.executionId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'executionId' field has been set.
      * @return True if the 'executionId' field has been set, false otherwise.
      */
    public boolean hasExecutionId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'executionId' field.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder clearExecutionId() {
      executionId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'script' field.
      * @return The value.
      */
    public java.lang.String getScript() {
      return script;
    }

    /**
      * Sets the value of the 'script' field.
      * @param value The value of 'script'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder setScript(java.lang.String value) {
      validate(fields()[1], value);
      this.script = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'script' field has been set.
      * @return True if the 'script' field has been set, false otherwise.
      */
    public boolean hasScript() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'script' field.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder clearScript() {
      script = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'testbedId' field.
      * @return The value.
      */
    public java.lang.String getTestbedId() {
      return testbedId;
    }

    /**
      * Sets the value of the 'testbedId' field.
      * @param value The value of 'testbedId'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder setTestbedId(java.lang.String value) {
      validate(fields()[2], value);
      this.testbedId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'testbedId' field has been set.
      * @return True if the 'testbedId' field has been set, false otherwise.
      */
    public boolean hasTestbedId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'testbedId' field.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder clearTestbedId() {
      testbedId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'isIndoor' field.
      * @return The value.
      */
    public java.lang.Boolean getIsIndoor() {
      return isIndoor;
    }

    /**
      * Sets the value of the 'isIndoor' field.
      * @param value The value of 'isIndoor'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder setIsIndoor(boolean value) {
      validate(fields()[3], value);
      this.isIndoor = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'isIndoor' field has been set.
      * @return True if the 'isIndoor' field has been set, false otherwise.
      */
    public boolean hasIsIndoor() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'isIndoor' field.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder clearIsIndoor() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'resourceNames' field.
      * @return The value.
      */
    public java.util.List<java.lang.String> getResourceNames() {
      return resourceNames;
    }

    /**
      * Sets the value of the 'resourceNames' field.
      * @param value The value of 'resourceNames'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder setResourceNames(java.util.List<java.lang.String> value) {
      validate(fields()[4], value);
      this.resourceNames = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'resourceNames' field has been set.
      * @return True if the 'resourceNames' field has been set, false otherwise.
      */
    public boolean hasResourceNames() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'resourceNames' field.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder clearResourceNames() {
      resourceNames = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'partitionids' field.
      * @return The value.
      */
    public java.util.List<java.lang.Integer> getPartitionids() {
      return partitionids;
    }

    /**
      * Sets the value of the 'partitionids' field.
      * @param value The value of 'partitionids'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder setPartitionids(java.util.List<java.lang.Integer> value) {
      validate(fields()[5], value);
      this.partitionids = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'partitionids' field has been set.
      * @return True if the 'partitionids' field has been set, false otherwise.
      */
    public boolean hasPartitionids() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'partitionids' field.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder clearPartitionids() {
      partitionids = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'accuracy' field.
      * Desired accuracy for the waypoint-navigation procedure
      * @return The value.
      */
    public java.lang.Double getAccuracy() {
      return accuracy;
    }

    /**
      * Sets the value of the 'accuracy' field.
      * Desired accuracy for the waypoint-navigation procedure
      * @param value The value of 'accuracy'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder setAccuracy(double value) {
      validate(fields()[6], value);
      this.accuracy = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'accuracy' field has been set.
      * Desired accuracy for the waypoint-navigation procedure
      * @return True if the 'accuracy' field has been set, false otherwise.
      */
    public boolean hasAccuracy() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'accuracy' field.
      * Desired accuracy for the waypoint-navigation procedure
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder clearAccuracy() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'takeOffHeights' field.
      * Desired take off height - For UAVs only
      * @return The value.
      */
    public java.util.List<java.lang.Double> getTakeOffHeights() {
      return takeOffHeights;
    }

    /**
      * Sets the value of the 'takeOffHeights' field.
      * Desired take off height - For UAVs only
      * @param value The value of 'takeOffHeights'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder setTakeOffHeights(java.util.List<java.lang.Double> value) {
      validate(fields()[7], value);
      this.takeOffHeights = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'takeOffHeights' field has been set.
      * Desired take off height - For UAVs only
      * @return True if the 'takeOffHeights' field has been set, false otherwise.
      */
    public boolean hasTakeOffHeights() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'takeOffHeights' field.
      * Desired take off height - For UAVs only
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder clearTakeOffHeights() {
      takeOffHeights = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'dynamicNavigation' field.
      * @return The value.
      */
    public java.lang.Boolean getDynamicNavigation() {
      return dynamicNavigation;
    }

    /**
      * Sets the value of the 'dynamicNavigation' field.
      * @param value The value of 'dynamicNavigation'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder setDynamicNavigation(boolean value) {
      validate(fields()[8], value);
      this.dynamicNavigation = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'dynamicNavigation' field has been set.
      * @return True if the 'dynamicNavigation' field has been set, false otherwise.
      */
    public boolean hasDynamicNavigation() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'dynamicNavigation' field.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.ExperimentChangeRequest.Builder clearDynamicNavigation() {
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    public ExperimentChangeRequest build() {
      try {
        ExperimentChangeRequest record = new ExperimentChangeRequest();
        record.executionId = fieldSetFlags()[0] ? this.executionId : (java.lang.String) defaultValue(fields()[0]);
        record.script = fieldSetFlags()[1] ? this.script : (java.lang.String) defaultValue(fields()[1]);
        record.testbedId = fieldSetFlags()[2] ? this.testbedId : (java.lang.String) defaultValue(fields()[2]);
        record.isIndoor = fieldSetFlags()[3] ? this.isIndoor : (java.lang.Boolean) defaultValue(fields()[3]);
        record.resourceNames = fieldSetFlags()[4] ? this.resourceNames : (java.util.List<java.lang.String>) defaultValue(fields()[4]);
        record.partitionids = fieldSetFlags()[5] ? this.partitionids : (java.util.List<java.lang.Integer>) defaultValue(fields()[5]);
        record.accuracy = fieldSetFlags()[6] ? this.accuracy : (java.lang.Double) defaultValue(fields()[6]);
        record.takeOffHeights = fieldSetFlags()[7] ? this.takeOffHeights : (java.util.List<java.lang.Double>) defaultValue(fields()[7]);
        record.dynamicNavigation = fieldSetFlags()[8] ? this.dynamicNavigation : (java.lang.Boolean) defaultValue(fields()[8]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
