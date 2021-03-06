/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.uxv;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** UxV proximity component connectivity data */
@org.apache.avro.specific.AvroGenerated
public class ProxyConnectData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5461043408725866960L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ProxyConnectData\",\"namespace\":\"eu.rawfie.uxv\",\"doc\":\"UxV proximity component connectivity data\",\"fields\":[{\"name\":\"header\",\"type\":{\"type\":\"record\",\"name\":\"Header\",\"fields\":[{\"name\":\"sourceSystem\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the originating system\"},{\"name\":\"sourceModule\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the module within a given system that originated the message\"},{\"name\":\"time\",\"type\":\"long\",\"doc\":\"Time elapsed since the Unix epoch\",\"unit\":\"ms\"}]}},{\"name\":\"srcaddress\",\"type\":\"int\",\"doc\":\"Source address of the beacon received by the proximity component\"},{\"name\":\"myaddress\",\"type\":\"int\",\"doc\":\"Address of the node that received the beacon to match with own UxV name\"},{\"name\":\"sequence\",\"type\":\"int\",\"doc\":\"Sequence number of the received beacon\"},{\"name\":\"rssi\",\"type\":\"int\",\"doc\":\"Received signal strength indicator associated of the received beacon\",\"unit\":\"dB(m)\"},{\"name\":\"lqi\",\"type\":\"int\",\"doc\":\"CC1101 radio linq quality indicator of the received beacon\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   public eu.rawfie.uxv.Header header;
  /** Source address of the beacon received by the proximity component */
   public int srcaddress;
  /** Address of the node that received the beacon to match with own UxV name */
   public int myaddress;
  /** Sequence number of the received beacon */
   public int sequence;
  /** Received signal strength indicator associated of the received beacon */
   public int rssi;
  /** CC1101 radio linq quality indicator of the received beacon */
   public int lqi;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ProxyConnectData() {}

  /**
   * All-args constructor.
   * @param header The new value for header
   * @param srcaddress Source address of the beacon received by the proximity component
   * @param myaddress Address of the node that received the beacon to match with own UxV name
   * @param sequence Sequence number of the received beacon
   * @param rssi Received signal strength indicator associated of the received beacon
   * @param lqi CC1101 radio linq quality indicator of the received beacon
   */
  public ProxyConnectData(eu.rawfie.uxv.Header header, java.lang.Integer srcaddress, java.lang.Integer myaddress, java.lang.Integer sequence, java.lang.Integer rssi, java.lang.Integer lqi) {
    this.header = header;
    this.srcaddress = srcaddress;
    this.myaddress = myaddress;
    this.sequence = sequence;
    this.rssi = rssi;
    this.lqi = lqi;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return header;
    case 1: return srcaddress;
    case 2: return myaddress;
    case 3: return sequence;
    case 4: return rssi;
    case 5: return lqi;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: header = (eu.rawfie.uxv.Header)value$; break;
    case 1: srcaddress = (java.lang.Integer)value$; break;
    case 2: myaddress = (java.lang.Integer)value$; break;
    case 3: sequence = (java.lang.Integer)value$; break;
    case 4: rssi = (java.lang.Integer)value$; break;
    case 5: lqi = (java.lang.Integer)value$; break;
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
   * Gets the value of the 'srcaddress' field.
   * @return Source address of the beacon received by the proximity component
   */
  public java.lang.Integer getSrcaddress() {
    return srcaddress;
  }

  /**
   * Sets the value of the 'srcaddress' field.
   * Source address of the beacon received by the proximity component
   * @param value the value to set.
   */
  public void setSrcaddress(java.lang.Integer value) {
    this.srcaddress = value;
  }

  /**
   * Gets the value of the 'myaddress' field.
   * @return Address of the node that received the beacon to match with own UxV name
   */
  public java.lang.Integer getMyaddress() {
    return myaddress;
  }

  /**
   * Sets the value of the 'myaddress' field.
   * Address of the node that received the beacon to match with own UxV name
   * @param value the value to set.
   */
  public void setMyaddress(java.lang.Integer value) {
    this.myaddress = value;
  }

  /**
   * Gets the value of the 'sequence' field.
   * @return Sequence number of the received beacon
   */
  public java.lang.Integer getSequence() {
    return sequence;
  }

  /**
   * Sets the value of the 'sequence' field.
   * Sequence number of the received beacon
   * @param value the value to set.
   */
  public void setSequence(java.lang.Integer value) {
    this.sequence = value;
  }

  /**
   * Gets the value of the 'rssi' field.
   * @return Received signal strength indicator associated of the received beacon
   */
  public java.lang.Integer getRssi() {
    return rssi;
  }

  /**
   * Sets the value of the 'rssi' field.
   * Received signal strength indicator associated of the received beacon
   * @param value the value to set.
   */
  public void setRssi(java.lang.Integer value) {
    this.rssi = value;
  }

  /**
   * Gets the value of the 'lqi' field.
   * @return CC1101 radio linq quality indicator of the received beacon
   */
  public java.lang.Integer getLqi() {
    return lqi;
  }

  /**
   * Sets the value of the 'lqi' field.
   * CC1101 radio linq quality indicator of the received beacon
   * @param value the value to set.
   */
  public void setLqi(java.lang.Integer value) {
    this.lqi = value;
  }

  /**
   * Creates a new ProxyConnectData RecordBuilder.
   * @return A new ProxyConnectData RecordBuilder
   */
  public static eu.rawfie.uxv.ProxyConnectData.Builder newBuilder() {
    return new eu.rawfie.uxv.ProxyConnectData.Builder();
  }

  /**
   * Creates a new ProxyConnectData RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ProxyConnectData RecordBuilder
   */
  public static eu.rawfie.uxv.ProxyConnectData.Builder newBuilder(eu.rawfie.uxv.ProxyConnectData.Builder other) {
    return new eu.rawfie.uxv.ProxyConnectData.Builder(other);
  }

  /**
   * Creates a new ProxyConnectData RecordBuilder by copying an existing ProxyConnectData instance.
   * @param other The existing instance to copy.
   * @return A new ProxyConnectData RecordBuilder
   */
  public static eu.rawfie.uxv.ProxyConnectData.Builder newBuilder(eu.rawfie.uxv.ProxyConnectData other) {
    return new eu.rawfie.uxv.ProxyConnectData.Builder(other);
  }

  /**
   * RecordBuilder for ProxyConnectData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ProxyConnectData>
    implements org.apache.avro.data.RecordBuilder<ProxyConnectData> {

    private eu.rawfie.uxv.Header header;
    private eu.rawfie.uxv.Header.Builder headerBuilder;
    /** Source address of the beacon received by the proximity component */
    private int srcaddress;
    /** Address of the node that received the beacon to match with own UxV name */
    private int myaddress;
    /** Sequence number of the received beacon */
    private int sequence;
    /** Received signal strength indicator associated of the received beacon */
    private int rssi;
    /** CC1101 radio linq quality indicator of the received beacon */
    private int lqi;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(eu.rawfie.uxv.ProxyConnectData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      if (other.hasHeaderBuilder()) {
        this.headerBuilder = eu.rawfie.uxv.Header.newBuilder(other.getHeaderBuilder());
      }
      if (isValidValue(fields()[1], other.srcaddress)) {
        this.srcaddress = data().deepCopy(fields()[1].schema(), other.srcaddress);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.myaddress)) {
        this.myaddress = data().deepCopy(fields()[2].schema(), other.myaddress);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.sequence)) {
        this.sequence = data().deepCopy(fields()[3].schema(), other.sequence);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.rssi)) {
        this.rssi = data().deepCopy(fields()[4].schema(), other.rssi);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.lqi)) {
        this.lqi = data().deepCopy(fields()[5].schema(), other.lqi);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ProxyConnectData instance
     * @param other The existing instance to copy.
     */
    private Builder(eu.rawfie.uxv.ProxyConnectData other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      this.headerBuilder = null;
      if (isValidValue(fields()[1], other.srcaddress)) {
        this.srcaddress = data().deepCopy(fields()[1].schema(), other.srcaddress);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.myaddress)) {
        this.myaddress = data().deepCopy(fields()[2].schema(), other.myaddress);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.sequence)) {
        this.sequence = data().deepCopy(fields()[3].schema(), other.sequence);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.rssi)) {
        this.rssi = data().deepCopy(fields()[4].schema(), other.rssi);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.lqi)) {
        this.lqi = data().deepCopy(fields()[5].schema(), other.lqi);
        fieldSetFlags()[5] = true;
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
    public eu.rawfie.uxv.ProxyConnectData.Builder setHeader(eu.rawfie.uxv.Header value) {
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
    public eu.rawfie.uxv.ProxyConnectData.Builder setHeaderBuilder(eu.rawfie.uxv.Header.Builder value) {
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
    public eu.rawfie.uxv.ProxyConnectData.Builder clearHeader() {
      header = null;
      headerBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'srcaddress' field.
      * Source address of the beacon received by the proximity component
      * @return The value.
      */
    public java.lang.Integer getSrcaddress() {
      return srcaddress;
    }

    /**
      * Sets the value of the 'srcaddress' field.
      * Source address of the beacon received by the proximity component
      * @param value The value of 'srcaddress'.
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder setSrcaddress(int value) {
      validate(fields()[1], value);
      this.srcaddress = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'srcaddress' field has been set.
      * Source address of the beacon received by the proximity component
      * @return True if the 'srcaddress' field has been set, false otherwise.
      */
    public boolean hasSrcaddress() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'srcaddress' field.
      * Source address of the beacon received by the proximity component
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder clearSrcaddress() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'myaddress' field.
      * Address of the node that received the beacon to match with own UxV name
      * @return The value.
      */
    public java.lang.Integer getMyaddress() {
      return myaddress;
    }

    /**
      * Sets the value of the 'myaddress' field.
      * Address of the node that received the beacon to match with own UxV name
      * @param value The value of 'myaddress'.
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder setMyaddress(int value) {
      validate(fields()[2], value);
      this.myaddress = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'myaddress' field has been set.
      * Address of the node that received the beacon to match with own UxV name
      * @return True if the 'myaddress' field has been set, false otherwise.
      */
    public boolean hasMyaddress() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'myaddress' field.
      * Address of the node that received the beacon to match with own UxV name
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder clearMyaddress() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'sequence' field.
      * Sequence number of the received beacon
      * @return The value.
      */
    public java.lang.Integer getSequence() {
      return sequence;
    }

    /**
      * Sets the value of the 'sequence' field.
      * Sequence number of the received beacon
      * @param value The value of 'sequence'.
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder setSequence(int value) {
      validate(fields()[3], value);
      this.sequence = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'sequence' field has been set.
      * Sequence number of the received beacon
      * @return True if the 'sequence' field has been set, false otherwise.
      */
    public boolean hasSequence() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'sequence' field.
      * Sequence number of the received beacon
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder clearSequence() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'rssi' field.
      * Received signal strength indicator associated of the received beacon
      * @return The value.
      */
    public java.lang.Integer getRssi() {
      return rssi;
    }

    /**
      * Sets the value of the 'rssi' field.
      * Received signal strength indicator associated of the received beacon
      * @param value The value of 'rssi'.
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder setRssi(int value) {
      validate(fields()[4], value);
      this.rssi = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'rssi' field has been set.
      * Received signal strength indicator associated of the received beacon
      * @return True if the 'rssi' field has been set, false otherwise.
      */
    public boolean hasRssi() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'rssi' field.
      * Received signal strength indicator associated of the received beacon
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder clearRssi() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'lqi' field.
      * CC1101 radio linq quality indicator of the received beacon
      * @return The value.
      */
    public java.lang.Integer getLqi() {
      return lqi;
    }

    /**
      * Sets the value of the 'lqi' field.
      * CC1101 radio linq quality indicator of the received beacon
      * @param value The value of 'lqi'.
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder setLqi(int value) {
      validate(fields()[5], value);
      this.lqi = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'lqi' field has been set.
      * CC1101 radio linq quality indicator of the received beacon
      * @return True if the 'lqi' field has been set, false otherwise.
      */
    public boolean hasLqi() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'lqi' field.
      * CC1101 radio linq quality indicator of the received beacon
      * @return This builder.
      */
    public eu.rawfie.uxv.ProxyConnectData.Builder clearLqi() {
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public ProxyConnectData build() {
      try {
        ProxyConnectData record = new ProxyConnectData();
        if (headerBuilder != null) {
          record.header = this.headerBuilder.build();
        } else {
          record.header = fieldSetFlags()[0] ? this.header : (eu.rawfie.uxv.Header) defaultValue(fields()[0]);
        }
        record.srcaddress = fieldSetFlags()[1] ? this.srcaddress : (java.lang.Integer) defaultValue(fields()[1]);
        record.myaddress = fieldSetFlags()[2] ? this.myaddress : (java.lang.Integer) defaultValue(fields()[2]);
        record.sequence = fieldSetFlags()[3] ? this.sequence : (java.lang.Integer) defaultValue(fields()[3]);
        record.rssi = fieldSetFlags()[4] ? this.rssi : (java.lang.Integer) defaultValue(fields()[4]);
        record.lqi = fieldSetFlags()[5] ? this.lqi : (java.lang.Integer) defaultValue(fields()[5]);
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
