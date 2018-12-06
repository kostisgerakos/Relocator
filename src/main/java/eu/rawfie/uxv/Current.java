/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.uxv;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** Measurement of electrical current */
@org.apache.avro.specific.AvroGenerated
public class Current extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5031746012539978757L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Current\",\"namespace\":\"eu.rawfie.uxv\",\"doc\":\"Measurement of electrical current\",\"fields\":[{\"name\":\"header\",\"type\":{\"type\":\"record\",\"name\":\"Header\",\"fields\":[{\"name\":\"sourceSystem\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the originating system\"},{\"name\":\"sourceModule\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the module within a given system that originated the message\"},{\"name\":\"time\",\"type\":\"long\",\"doc\":\"Time elapsed since the Unix epoch\",\"unit\":\"ms\"}]}},{\"name\":\"value\",\"type\":\"float\",\"doc\":\"Value\",\"unit\":\"A\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   public eu.rawfie.uxv.Header header;
  /** Value */
   public float value;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Current() {}

  /**
   * All-args constructor.
   * @param header The new value for header
   * @param value Value
   */
  public Current(eu.rawfie.uxv.Header header, java.lang.Float value) {
    this.header = header;
    this.value = value;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return header;
    case 1: return value;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: header = (eu.rawfie.uxv.Header)value$; break;
    case 1: value = (java.lang.Float)value$; break;
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
   * Gets the value of the 'value' field.
   * @return Value
   */
  public java.lang.Float getValue() {
    return value;
  }

  /**
   * Sets the value of the 'value' field.
   * Value
   * @param value the value to set.
   */
  public void setValue(java.lang.Float value) {
    this.value = value;
  }

  /**
   * Creates a new Current RecordBuilder.
   * @return A new Current RecordBuilder
   */
  public static eu.rawfie.uxv.Current.Builder newBuilder() {
    return new eu.rawfie.uxv.Current.Builder();
  }

  /**
   * Creates a new Current RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Current RecordBuilder
   */
  public static eu.rawfie.uxv.Current.Builder newBuilder(eu.rawfie.uxv.Current.Builder other) {
    return new eu.rawfie.uxv.Current.Builder(other);
  }

  /**
   * Creates a new Current RecordBuilder by copying an existing Current instance.
   * @param other The existing instance to copy.
   * @return A new Current RecordBuilder
   */
  public static eu.rawfie.uxv.Current.Builder newBuilder(eu.rawfie.uxv.Current other) {
    return new eu.rawfie.uxv.Current.Builder(other);
  }

  /**
   * RecordBuilder for Current instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Current>
    implements org.apache.avro.data.RecordBuilder<Current> {

    private eu.rawfie.uxv.Header header;
    private eu.rawfie.uxv.Header.Builder headerBuilder;
    /** Value */
    private float value;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(eu.rawfie.uxv.Current.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      if (other.hasHeaderBuilder()) {
        this.headerBuilder = eu.rawfie.uxv.Header.newBuilder(other.getHeaderBuilder());
      }
      if (isValidValue(fields()[1], other.value)) {
        this.value = data().deepCopy(fields()[1].schema(), other.value);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Current instance
     * @param other The existing instance to copy.
     */
    private Builder(eu.rawfie.uxv.Current other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      this.headerBuilder = null;
      if (isValidValue(fields()[1], other.value)) {
        this.value = data().deepCopy(fields()[1].schema(), other.value);
        fieldSetFlags()[1] = true;
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
    public eu.rawfie.uxv.Current.Builder setHeader(eu.rawfie.uxv.Header value) {
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
    public eu.rawfie.uxv.Current.Builder setHeaderBuilder(eu.rawfie.uxv.Header.Builder value) {
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
    public eu.rawfie.uxv.Current.Builder clearHeader() {
      header = null;
      headerBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * Value
      * @return The value.
      */
    public java.lang.Float getValue() {
      return value;
    }

    /**
      * Sets the value of the 'value' field.
      * Value
      * @param value The value of 'value'.
      * @return This builder.
      */
    public eu.rawfie.uxv.Current.Builder setValue(float value) {
      validate(fields()[1], value);
      this.value = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * Value
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'value' field.
      * Value
      * @return This builder.
      */
    public eu.rawfie.uxv.Current.Builder clearValue() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Current build() {
      try {
        Current record = new Current();
        if (headerBuilder != null) {
          record.header = this.headerBuilder.build();
        } else {
          record.header = fieldSetFlags()[0] ? this.header : (eu.rawfie.uxv.Header) defaultValue(fields()[0]);
        }
        record.value = fieldSetFlags()[1] ? this.value : (java.lang.Float) defaultValue(fields()[1]);
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
