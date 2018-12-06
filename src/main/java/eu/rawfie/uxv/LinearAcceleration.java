/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.uxv;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** Vector quantifying the direction and magnitude of the measured linear acceleration that a UxV is exposed to */
@org.apache.avro.specific.AvroGenerated
public class LinearAcceleration extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4487447407885699889L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"LinearAcceleration\",\"namespace\":\"eu.rawfie.uxv\",\"doc\":\"Vector quantifying the direction and magnitude of the measured linear acceleration that a UxV is exposed to\",\"fields\":[{\"name\":\"header\",\"type\":{\"type\":\"record\",\"name\":\"Header\",\"fields\":[{\"name\":\"sourceSystem\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the originating system\"},{\"name\":\"sourceModule\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the module within a given system that originated the message\"},{\"name\":\"time\",\"type\":\"long\",\"doc\":\"Time elapsed since the Unix epoch\",\"unit\":\"ms\"}]}},{\"name\":\"x\",\"type\":\"float\",\"doc\":\"Rotation around the body's longitudinal axis\",\"unit\":\"m/s/s\"},{\"name\":\"y\",\"type\":\"float\",\"doc\":\"Rotation around the body's lateral or transverse axis\",\"unit\":\"m/s/s\"},{\"name\":\"z\",\"type\":\"float\",\"doc\":\"Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north\",\"unit\":\"m/s/s\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   public eu.rawfie.uxv.Header header;
  /** Rotation around the body's longitudinal axis */
   public float x;
  /** Rotation around the body's lateral or transverse axis */
   public float y;
  /** Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north */
   public float z;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public LinearAcceleration() {}

  /**
   * All-args constructor.
   * @param header The new value for header
   * @param x Rotation around the body's longitudinal axis
   * @param y Rotation around the body's lateral or transverse axis
   * @param z Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north
   */
  public LinearAcceleration(eu.rawfie.uxv.Header header, java.lang.Float x, java.lang.Float y, java.lang.Float z) {
    this.header = header;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return header;
    case 1: return x;
    case 2: return y;
    case 3: return z;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: header = (eu.rawfie.uxv.Header)value$; break;
    case 1: x = (java.lang.Float)value$; break;
    case 2: y = (java.lang.Float)value$; break;
    case 3: z = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'header' field.
   * @return The value of the 'header' field.
   */
  public eu.rawfie.uxv.Header getHeader() {
    return header;
  }

  /**
   * Sets the value of the 'header' field.
   * @param value the value to set.
   */
  public void setHeader(eu.rawfie.uxv.Header value) {
    this.header = value;
  }

  /**
   * Gets the value of the 'x' field.
   * @return Rotation around the body's longitudinal axis
   */
  public java.lang.Float getX() {
    return x;
  }

  /**
   * Sets the value of the 'x' field.
   * Rotation around the body's longitudinal axis
   * @param value the value to set.
   */
  public void setX(java.lang.Float value) {
    this.x = value;
  }

  /**
   * Gets the value of the 'y' field.
   * @return Rotation around the body's lateral or transverse axis
   */
  public java.lang.Float getY() {
    return y;
  }

  /**
   * Sets the value of the 'y' field.
   * Rotation around the body's lateral or transverse axis
   * @param value the value to set.
   */
  public void setY(java.lang.Float value) {
    this.y = value;
  }

  /**
   * Gets the value of the 'z' field.
   * @return Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north
   */
  public java.lang.Float getZ() {
    return z;
  }

  /**
   * Sets the value of the 'z' field.
   * Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north
   * @param value the value to set.
   */
  public void setZ(java.lang.Float value) {
    this.z = value;
  }

  /**
   * Creates a new LinearAcceleration RecordBuilder.
   * @return A new LinearAcceleration RecordBuilder
   */
  public static eu.rawfie.uxv.LinearAcceleration.Builder newBuilder() {
    return new eu.rawfie.uxv.LinearAcceleration.Builder();
  }

  /**
   * Creates a new LinearAcceleration RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new LinearAcceleration RecordBuilder
   */
  public static eu.rawfie.uxv.LinearAcceleration.Builder newBuilder(eu.rawfie.uxv.LinearAcceleration.Builder other) {
    return new eu.rawfie.uxv.LinearAcceleration.Builder(other);
  }

  /**
   * Creates a new LinearAcceleration RecordBuilder by copying an existing LinearAcceleration instance.
   * @param other The existing instance to copy.
   * @return A new LinearAcceleration RecordBuilder
   */
  public static eu.rawfie.uxv.LinearAcceleration.Builder newBuilder(eu.rawfie.uxv.LinearAcceleration other) {
    return new eu.rawfie.uxv.LinearAcceleration.Builder(other);
  }

  /**
   * RecordBuilder for LinearAcceleration instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<LinearAcceleration>
    implements org.apache.avro.data.RecordBuilder<LinearAcceleration> {

    private eu.rawfie.uxv.Header header;
    private eu.rawfie.uxv.Header.Builder headerBuilder;
    /** Rotation around the body's longitudinal axis */
    private float x;
    /** Rotation around the body's lateral or transverse axis */
    private float y;
    /** Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north */
    private float z;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(eu.rawfie.uxv.LinearAcceleration.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      if (other.hasHeaderBuilder()) {
        this.headerBuilder = eu.rawfie.uxv.Header.newBuilder(other.getHeaderBuilder());
      }
      if (isValidValue(fields()[1], other.x)) {
        this.x = data().deepCopy(fields()[1].schema(), other.x);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.y)) {
        this.y = data().deepCopy(fields()[2].schema(), other.y);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.z)) {
        this.z = data().deepCopy(fields()[3].schema(), other.z);
        fieldSetFlags()[3] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing LinearAcceleration instance
     * @param other The existing instance to copy.
     */
    private Builder(eu.rawfie.uxv.LinearAcceleration other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      this.headerBuilder = null;
      if (isValidValue(fields()[1], other.x)) {
        this.x = data().deepCopy(fields()[1].schema(), other.x);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.y)) {
        this.y = data().deepCopy(fields()[2].schema(), other.y);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.z)) {
        this.z = data().deepCopy(fields()[3].schema(), other.z);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'header' field.
      * @return The value.
      */
    public eu.rawfie.uxv.Header getHeader() {
      return header;
    }

    /**
      * Sets the value of the 'header' field.
      * @param value The value of 'header'.
      * @return This builder.
      */
    public eu.rawfie.uxv.LinearAcceleration.Builder setHeader(eu.rawfie.uxv.Header value) {
      validate(fields()[0], value);
      this.headerBuilder = null;
      this.header = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'header' field has been set.
      * @return True if the 'header' field has been set, false otherwise.
      */
    public boolean hasHeader() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'header' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public eu.rawfie.uxv.Header.Builder getHeaderBuilder() {
      if (headerBuilder == null) {
        if (hasHeader()) {
          setHeaderBuilder(eu.rawfie.uxv.Header.newBuilder(header));
        } else {
          setHeaderBuilder(eu.rawfie.uxv.Header.newBuilder());
        }
      }
      return headerBuilder;
    }

    /**
     * Sets the Builder instance for the 'header' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public eu.rawfie.uxv.LinearAcceleration.Builder setHeaderBuilder(eu.rawfie.uxv.Header.Builder value) {
      clearHeader();
      headerBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'header' field has an active Builder instance
     * @return True if the 'header' field has an active Builder instance
     */
    public boolean hasHeaderBuilder() {
      return headerBuilder != null;
    }

    /**
      * Clears the value of the 'header' field.
      * @return This builder.
      */
    public eu.rawfie.uxv.LinearAcceleration.Builder clearHeader() {
      header = null;
      headerBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'x' field.
      * Rotation around the body's longitudinal axis
      * @return The value.
      */
    public java.lang.Float getX() {
      return x;
    }

    /**
      * Sets the value of the 'x' field.
      * Rotation around the body's longitudinal axis
      * @param value The value of 'x'.
      * @return This builder.
      */
    public eu.rawfie.uxv.LinearAcceleration.Builder setX(float value) {
      validate(fields()[1], value);
      this.x = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'x' field has been set.
      * Rotation around the body's longitudinal axis
      * @return True if the 'x' field has been set, false otherwise.
      */
    public boolean hasX() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'x' field.
      * Rotation around the body's longitudinal axis
      * @return This builder.
      */
    public eu.rawfie.uxv.LinearAcceleration.Builder clearX() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'y' field.
      * Rotation around the body's lateral or transverse axis
      * @return The value.
      */
    public java.lang.Float getY() {
      return y;
    }

    /**
      * Sets the value of the 'y' field.
      * Rotation around the body's lateral or transverse axis
      * @param value The value of 'y'.
      * @return This builder.
      */
    public eu.rawfie.uxv.LinearAcceleration.Builder setY(float value) {
      validate(fields()[2], value);
      this.y = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'y' field has been set.
      * Rotation around the body's lateral or transverse axis
      * @return True if the 'y' field has been set, false otherwise.
      */
    public boolean hasY() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'y' field.
      * Rotation around the body's lateral or transverse axis
      * @return This builder.
      */
    public eu.rawfie.uxv.LinearAcceleration.Builder clearY() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'z' field.
      * Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north
      * @return The value.
      */
    public java.lang.Float getZ() {
      return z;
    }

    /**
      * Sets the value of the 'z' field.
      * Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north
      * @param value The value of 'z'.
      * @return This builder.
      */
    public eu.rawfie.uxv.LinearAcceleration.Builder setZ(float value) {
      validate(fields()[3], value);
      this.z = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'z' field has been set.
      * Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north
      * @return True if the 'z' field has been set, false otherwise.
      */
    public boolean hasZ() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'z' field.
      * Rotation around the body's vertical axis. A value of 0 means the body is oriented towards true north
      * @return This builder.
      */
    public eu.rawfie.uxv.LinearAcceleration.Builder clearZ() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public LinearAcceleration build() {
      try {
        LinearAcceleration record = new LinearAcceleration();
        if (headerBuilder != null) {
          record.header = this.headerBuilder.build();
        } else {
          record.header = fieldSetFlags()[0] ? this.header : (eu.rawfie.uxv.Header) defaultValue(fields()[0]);
        }
        record.x = fieldSetFlags()[1] ? this.x : (java.lang.Float) defaultValue(fields()[1]);
        record.y = fieldSetFlags()[2] ? this.y : (java.lang.Float) defaultValue(fields()[2]);
        record.z = fieldSetFlags()[3] ? this.z : (java.lang.Float) defaultValue(fields()[3]);
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