/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.general.service.types;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** Start the execution of specific algorithm with certain parameters */
@org.apache.avro.specific.AvroGenerated
public class AlgorithmStart extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5415202497218906532L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AlgorithmStart\",\"namespace\":\"eu.rawfie.general.service.types\",\"doc\":\"Start the execution of specific algorithm with certain parameters\",\"fields\":[{\"name\":\"destinationModule\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the controlled module\"},{\"name\":\"types\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"AlgorithmTypeEnum\",\"symbols\":[\"average\",\"maximum\",\"minimum\",\"datareporting\"]}},\"doc\":\"Applicable quantities\"},{\"name\":\"parameters\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"Pass the parameters of the algorithm (if any)\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** Canonical name of the controlled module */
   public java.lang.String destinationModule;
  /** Applicable quantities */
   public java.util.List<eu.rawfie.general.service.types.AlgorithmTypeEnum> types;
  /** Pass the parameters of the algorithm (if any) */
   public java.lang.String parameters;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AlgorithmStart() {}

  /**
   * All-args constructor.
   * @param destinationModule Canonical name of the controlled module
   * @param types Applicable quantities
   * @param parameters Pass the parameters of the algorithm (if any)
   */
  public AlgorithmStart(java.lang.String destinationModule, java.util.List<eu.rawfie.general.service.types.AlgorithmTypeEnum> types, java.lang.String parameters) {
    this.destinationModule = destinationModule;
    this.types = types;
    this.parameters = parameters;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return destinationModule;
    case 1: return types;
    case 2: return parameters;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: destinationModule = (java.lang.String)value$; break;
    case 1: types = (java.util.List<eu.rawfie.general.service.types.AlgorithmTypeEnum>)value$; break;
    case 2: parameters = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'destinationModule' field.
   * @return Canonical name of the controlled module
   */
  public java.lang.String getDestinationModule() {
    return destinationModule;
  }

  /**
   * Sets the value of the 'destinationModule' field.
   * Canonical name of the controlled module
   * @param value the value to set.
   */
  public void setDestinationModule(java.lang.String value) {
    this.destinationModule = value;
  }

  /**
   * Gets the value of the 'types' field.
   * @return Applicable quantities
   */
  public java.util.List<eu.rawfie.general.service.types.AlgorithmTypeEnum> getTypes() {
    return types;
  }

  /**
   * Sets the value of the 'types' field.
   * Applicable quantities
   * @param value the value to set.
   */
  public void setTypes(java.util.List<eu.rawfie.general.service.types.AlgorithmTypeEnum> value) {
    this.types = value;
  }

  /**
   * Gets the value of the 'parameters' field.
   * @return Pass the parameters of the algorithm (if any)
   */
  public java.lang.String getParameters() {
    return parameters;
  }

  /**
   * Sets the value of the 'parameters' field.
   * Pass the parameters of the algorithm (if any)
   * @param value the value to set.
   */
  public void setParameters(java.lang.String value) {
    this.parameters = value;
  }

  /**
   * Creates a new AlgorithmStart RecordBuilder.
   * @return A new AlgorithmStart RecordBuilder
   */
  public static eu.rawfie.general.service.types.AlgorithmStart.Builder newBuilder() {
    return new eu.rawfie.general.service.types.AlgorithmStart.Builder();
  }

  /**
   * Creates a new AlgorithmStart RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AlgorithmStart RecordBuilder
   */
  public static eu.rawfie.general.service.types.AlgorithmStart.Builder newBuilder(eu.rawfie.general.service.types.AlgorithmStart.Builder other) {
    return new eu.rawfie.general.service.types.AlgorithmStart.Builder(other);
  }

  /**
   * Creates a new AlgorithmStart RecordBuilder by copying an existing AlgorithmStart instance.
   * @param other The existing instance to copy.
   * @return A new AlgorithmStart RecordBuilder
   */
  public static eu.rawfie.general.service.types.AlgorithmStart.Builder newBuilder(eu.rawfie.general.service.types.AlgorithmStart other) {
    return new eu.rawfie.general.service.types.AlgorithmStart.Builder(other);
  }

  /**
   * RecordBuilder for AlgorithmStart instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AlgorithmStart>
    implements org.apache.avro.data.RecordBuilder<AlgorithmStart> {

    /** Canonical name of the controlled module */
    private java.lang.String destinationModule;
    /** Applicable quantities */
    private java.util.List<eu.rawfie.general.service.types.AlgorithmTypeEnum> types;
    /** Pass the parameters of the algorithm (if any) */
    private java.lang.String parameters;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(eu.rawfie.general.service.types.AlgorithmStart.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.destinationModule)) {
        this.destinationModule = data().deepCopy(fields()[0].schema(), other.destinationModule);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.types)) {
        this.types = data().deepCopy(fields()[1].schema(), other.types);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.parameters)) {
        this.parameters = data().deepCopy(fields()[2].schema(), other.parameters);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing AlgorithmStart instance
     * @param other The existing instance to copy.
     */
    private Builder(eu.rawfie.general.service.types.AlgorithmStart other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.destinationModule)) {
        this.destinationModule = data().deepCopy(fields()[0].schema(), other.destinationModule);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.types)) {
        this.types = data().deepCopy(fields()[1].schema(), other.types);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.parameters)) {
        this.parameters = data().deepCopy(fields()[2].schema(), other.parameters);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'destinationModule' field.
      * Canonical name of the controlled module
      * @return The value.
      */
    public java.lang.String getDestinationModule() {
      return destinationModule;
    }

    /**
      * Sets the value of the 'destinationModule' field.
      * Canonical name of the controlled module
      * @param value The value of 'destinationModule'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.AlgorithmStart.Builder setDestinationModule(java.lang.String value) {
      validate(fields()[0], value);
      this.destinationModule = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'destinationModule' field has been set.
      * Canonical name of the controlled module
      * @return True if the 'destinationModule' field has been set, false otherwise.
      */
    public boolean hasDestinationModule() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'destinationModule' field.
      * Canonical name of the controlled module
      * @return This builder.
      */
    public eu.rawfie.general.service.types.AlgorithmStart.Builder clearDestinationModule() {
      destinationModule = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'types' field.
      * Applicable quantities
      * @return The value.
      */
    public java.util.List<eu.rawfie.general.service.types.AlgorithmTypeEnum> getTypes() {
      return types;
    }

    /**
      * Sets the value of the 'types' field.
      * Applicable quantities
      * @param value The value of 'types'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.AlgorithmStart.Builder setTypes(java.util.List<eu.rawfie.general.service.types.AlgorithmTypeEnum> value) {
      validate(fields()[1], value);
      this.types = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'types' field has been set.
      * Applicable quantities
      * @return True if the 'types' field has been set, false otherwise.
      */
    public boolean hasTypes() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'types' field.
      * Applicable quantities
      * @return This builder.
      */
    public eu.rawfie.general.service.types.AlgorithmStart.Builder clearTypes() {
      types = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'parameters' field.
      * Pass the parameters of the algorithm (if any)
      * @return The value.
      */
    public java.lang.String getParameters() {
      return parameters;
    }

    /**
      * Sets the value of the 'parameters' field.
      * Pass the parameters of the algorithm (if any)
      * @param value The value of 'parameters'.
      * @return This builder.
      */
    public eu.rawfie.general.service.types.AlgorithmStart.Builder setParameters(java.lang.String value) {
      validate(fields()[2], value);
      this.parameters = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'parameters' field has been set.
      * Pass the parameters of the algorithm (if any)
      * @return True if the 'parameters' field has been set, false otherwise.
      */
    public boolean hasParameters() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'parameters' field.
      * Pass the parameters of the algorithm (if any)
      * @return This builder.
      */
    public eu.rawfie.general.service.types.AlgorithmStart.Builder clearParameters() {
      parameters = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public AlgorithmStart build() {
      try {
        AlgorithmStart record = new AlgorithmStart();
        record.destinationModule = fieldSetFlags()[0] ? this.destinationModule : (java.lang.String) defaultValue(fields()[0]);
        record.types = fieldSetFlags()[1] ? this.types : (java.util.List<eu.rawfie.general.service.types.AlgorithmTypeEnum>) defaultValue(fields()[1]);
        record.parameters = fieldSetFlags()[2] ? this.parameters : (java.lang.String) defaultValue(fields()[2]);
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
