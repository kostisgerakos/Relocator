/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package eu.rawfie.uxv;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** Info of a captured imaged */
@org.apache.avro.specific.AvroGenerated
public class CamCapturedInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 398562943312836375L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CamCapturedInfo\",\"namespace\":\"eu.rawfie.uxv\",\"doc\":\"Info of a captured imaged\",\"fields\":[{\"name\":\"header\",\"type\":{\"type\":\"record\",\"name\":\"Header\",\"fields\":[{\"name\":\"sourceSystem\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the originating system\"},{\"name\":\"sourceModule\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Canonical name of the module within a given system that originated the message\"},{\"name\":\"time\",\"type\":\"long\",\"doc\":\"Time elapsed since the Unix epoch\",\"unit\":\"ms\"}]}},{\"name\":\"lat\",\"type\":\"float\",\"doc\":\"Latitude where image was taken\",\"unit\":\"degree\"},{\"name\":\"lon\",\"type\":\"float\",\"doc\":\"Longitude where image was taken)\",\"unit\":\"degree\"},{\"name\":\"alt\",\"type\":\"float\",\"doc\":\"Altitude AMSL (Above Mean Sea Level) where image was taken\",\"unit\":\"m\"},{\"name\":\"relative_alt\",\"type\":\"float\",\"doc\":\"Altitude above the ground\",\"unit\":\"m\"},{\"name\":\"roll\",\"type\":\"float\",\"doc\":\"Camera Roll angle (earth frame, +-180)\"},{\"name\":\"pitch\",\"type\":\"float\",\"doc\":\"Camera Pitch angle (earth frame, +-180)\"},{\"name\":\"yaw\",\"type\":\"float\",\"doc\":\"Camera Yaw (earth frame, 0-360, true)\"},{\"name\":\"image_index\",\"type\":\"int\",\"doc\":\"Zero-based index of the image since vehicle armed\"},{\"name\":\"capture_result\",\"type\":\"int\",\"doc\":\"Indicator for success (1) or failure (0) capturing the image\"},{\"name\":\"file_url\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"URL of image taken\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   public eu.rawfie.uxv.Header header;
  /** Latitude where image was taken */
   public float lat;
  /** Longitude where image was taken) */
   public float lon;
  /** Altitude AMSL (Above Mean Sea Level) where image was taken */
   public float alt;
  /** Altitude above the ground */
   public float relative_alt;
  /** Camera Roll angle (earth frame, +-180) */
   public float roll;
  /** Camera Pitch angle (earth frame, +-180) */
   public float pitch;
  /** Camera Yaw (earth frame, 0-360, true) */
   public float yaw;
  /** Zero-based index of the image since vehicle armed */
   public int image_index;
  /** Indicator for success (1) or failure (0) capturing the image */
   public int capture_result;
  /** URL of image taken */
   public java.lang.String file_url;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CamCapturedInfo() {}

  /**
   * All-args constructor.
   * @param header The new value for header
   * @param lat Latitude where image was taken
   * @param lon Longitude where image was taken)
   * @param alt Altitude AMSL (Above Mean Sea Level) where image was taken
   * @param relative_alt Altitude above the ground
   * @param roll Camera Roll angle (earth frame, +-180)
   * @param pitch Camera Pitch angle (earth frame, +-180)
   * @param yaw Camera Yaw (earth frame, 0-360, true)
   * @param image_index Zero-based index of the image since vehicle armed
   * @param capture_result Indicator for success (1) or failure (0) capturing the image
   * @param file_url URL of image taken
   */
  public CamCapturedInfo(eu.rawfie.uxv.Header header, java.lang.Float lat, java.lang.Float lon, java.lang.Float alt, java.lang.Float relative_alt, java.lang.Float roll, java.lang.Float pitch, java.lang.Float yaw, java.lang.Integer image_index, java.lang.Integer capture_result, java.lang.String file_url) {
    this.header = header;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.relative_alt = relative_alt;
    this.roll = roll;
    this.pitch = pitch;
    this.yaw = yaw;
    this.image_index = image_index;
    this.capture_result = capture_result;
    this.file_url = file_url;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return header;
    case 1: return lat;
    case 2: return lon;
    case 3: return alt;
    case 4: return relative_alt;
    case 5: return roll;
    case 6: return pitch;
    case 7: return yaw;
    case 8: return image_index;
    case 9: return capture_result;
    case 10: return file_url;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: header = (eu.rawfie.uxv.Header)value$; break;
    case 1: lat = (java.lang.Float)value$; break;
    case 2: lon = (java.lang.Float)value$; break;
    case 3: alt = (java.lang.Float)value$; break;
    case 4: relative_alt = (java.lang.Float)value$; break;
    case 5: roll = (java.lang.Float)value$; break;
    case 6: pitch = (java.lang.Float)value$; break;
    case 7: yaw = (java.lang.Float)value$; break;
    case 8: image_index = (java.lang.Integer)value$; break;
    case 9: capture_result = (java.lang.Integer)value$; break;
    case 10: file_url = (java.lang.String)value$; break;
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
   * Gets the value of the 'lat' field.
   * @return Latitude where image was taken
   */
  public java.lang.Float getLat() {
    return lat;
  }

  /**
   * Sets the value of the 'lat' field.
   * Latitude where image was taken
   * @param value the value to set.
   */
  public void setLat(java.lang.Float value) {
    this.lat = value;
  }

  /**
   * Gets the value of the 'lon' field.
   * @return Longitude where image was taken)
   */
  public java.lang.Float getLon() {
    return lon;
  }

  /**
   * Sets the value of the 'lon' field.
   * Longitude where image was taken)
   * @param value the value to set.
   */
  public void setLon(java.lang.Float value) {
    this.lon = value;
  }

  /**
   * Gets the value of the 'alt' field.
   * @return Altitude AMSL (Above Mean Sea Level) where image was taken
   */
  public java.lang.Float getAlt() {
    return alt;
  }

  /**
   * Sets the value of the 'alt' field.
   * Altitude AMSL (Above Mean Sea Level) where image was taken
   * @param value the value to set.
   */
  public void setAlt(java.lang.Float value) {
    this.alt = value;
  }

  /**
   * Gets the value of the 'relative_alt' field.
   * @return Altitude above the ground
   */
  public java.lang.Float getRelativeAlt() {
    return relative_alt;
  }

  /**
   * Sets the value of the 'relative_alt' field.
   * Altitude above the ground
   * @param value the value to set.
   */
  public void setRelativeAlt(java.lang.Float value) {
    this.relative_alt = value;
  }

  /**
   * Gets the value of the 'roll' field.
   * @return Camera Roll angle (earth frame, +-180)
   */
  public java.lang.Float getRoll() {
    return roll;
  }

  /**
   * Sets the value of the 'roll' field.
   * Camera Roll angle (earth frame, +-180)
   * @param value the value to set.
   */
  public void setRoll(java.lang.Float value) {
    this.roll = value;
  }

  /**
   * Gets the value of the 'pitch' field.
   * @return Camera Pitch angle (earth frame, +-180)
   */
  public java.lang.Float getPitch() {
    return pitch;
  }

  /**
   * Sets the value of the 'pitch' field.
   * Camera Pitch angle (earth frame, +-180)
   * @param value the value to set.
   */
  public void setPitch(java.lang.Float value) {
    this.pitch = value;
  }

  /**
   * Gets the value of the 'yaw' field.
   * @return Camera Yaw (earth frame, 0-360, true)
   */
  public java.lang.Float getYaw() {
    return yaw;
  }

  /**
   * Sets the value of the 'yaw' field.
   * Camera Yaw (earth frame, 0-360, true)
   * @param value the value to set.
   */
  public void setYaw(java.lang.Float value) {
    this.yaw = value;
  }

  /**
   * Gets the value of the 'image_index' field.
   * @return Zero-based index of the image since vehicle armed
   */
  public java.lang.Integer getImageIndex() {
    return image_index;
  }

  /**
   * Sets the value of the 'image_index' field.
   * Zero-based index of the image since vehicle armed
   * @param value the value to set.
   */
  public void setImageIndex(java.lang.Integer value) {
    this.image_index = value;
  }

  /**
   * Gets the value of the 'capture_result' field.
   * @return Indicator for success (1) or failure (0) capturing the image
   */
  public java.lang.Integer getCaptureResult() {
    return capture_result;
  }

  /**
   * Sets the value of the 'capture_result' field.
   * Indicator for success (1) or failure (0) capturing the image
   * @param value the value to set.
   */
  public void setCaptureResult(java.lang.Integer value) {
    this.capture_result = value;
  }

  /**
   * Gets the value of the 'file_url' field.
   * @return URL of image taken
   */
  public java.lang.String getFileUrl() {
    return file_url;
  }

  /**
   * Sets the value of the 'file_url' field.
   * URL of image taken
   * @param value the value to set.
   */
  public void setFileUrl(java.lang.String value) {
    this.file_url = value;
  }

  /**
   * Creates a new CamCapturedInfo RecordBuilder.
   * @return A new CamCapturedInfo RecordBuilder
   */
  public static eu.rawfie.uxv.CamCapturedInfo.Builder newBuilder() {
    return new eu.rawfie.uxv.CamCapturedInfo.Builder();
  }

  /**
   * Creates a new CamCapturedInfo RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CamCapturedInfo RecordBuilder
   */
  public static eu.rawfie.uxv.CamCapturedInfo.Builder newBuilder(eu.rawfie.uxv.CamCapturedInfo.Builder other) {
    return new eu.rawfie.uxv.CamCapturedInfo.Builder(other);
  }

  /**
   * Creates a new CamCapturedInfo RecordBuilder by copying an existing CamCapturedInfo instance.
   * @param other The existing instance to copy.
   * @return A new CamCapturedInfo RecordBuilder
   */
  public static eu.rawfie.uxv.CamCapturedInfo.Builder newBuilder(eu.rawfie.uxv.CamCapturedInfo other) {
    return new eu.rawfie.uxv.CamCapturedInfo.Builder(other);
  }

  /**
   * RecordBuilder for CamCapturedInfo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CamCapturedInfo>
    implements org.apache.avro.data.RecordBuilder<CamCapturedInfo> {

    private eu.rawfie.uxv.Header header;
    private eu.rawfie.uxv.Header.Builder headerBuilder;
    /** Latitude where image was taken */
    private float lat;
    /** Longitude where image was taken) */
    private float lon;
    /** Altitude AMSL (Above Mean Sea Level) where image was taken */
    private float alt;
    /** Altitude above the ground */
    private float relative_alt;
    /** Camera Roll angle (earth frame, +-180) */
    private float roll;
    /** Camera Pitch angle (earth frame, +-180) */
    private float pitch;
    /** Camera Yaw (earth frame, 0-360, true) */
    private float yaw;
    /** Zero-based index of the image since vehicle armed */
    private int image_index;
    /** Indicator for success (1) or failure (0) capturing the image */
    private int capture_result;
    /** URL of image taken */
    private java.lang.String file_url;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(eu.rawfie.uxv.CamCapturedInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      if (other.hasHeaderBuilder()) {
        this.headerBuilder = eu.rawfie.uxv.Header.newBuilder(other.getHeaderBuilder());
      }
      if (isValidValue(fields()[1], other.lat)) {
        this.lat = data().deepCopy(fields()[1].schema(), other.lat);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lon)) {
        this.lon = data().deepCopy(fields()[2].schema(), other.lon);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.alt)) {
        this.alt = data().deepCopy(fields()[3].schema(), other.alt);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.relative_alt)) {
        this.relative_alt = data().deepCopy(fields()[4].schema(), other.relative_alt);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.roll)) {
        this.roll = data().deepCopy(fields()[5].schema(), other.roll);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.pitch)) {
        this.pitch = data().deepCopy(fields()[6].schema(), other.pitch);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.yaw)) {
        this.yaw = data().deepCopy(fields()[7].schema(), other.yaw);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.image_index)) {
        this.image_index = data().deepCopy(fields()[8].schema(), other.image_index);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.capture_result)) {
        this.capture_result = data().deepCopy(fields()[9].schema(), other.capture_result);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.file_url)) {
        this.file_url = data().deepCopy(fields()[10].schema(), other.file_url);
        fieldSetFlags()[10] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing CamCapturedInfo instance
     * @param other The existing instance to copy.
     */
    private Builder(eu.rawfie.uxv.CamCapturedInfo other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      this.headerBuilder = null;
      if (isValidValue(fields()[1], other.lat)) {
        this.lat = data().deepCopy(fields()[1].schema(), other.lat);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lon)) {
        this.lon = data().deepCopy(fields()[2].schema(), other.lon);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.alt)) {
        this.alt = data().deepCopy(fields()[3].schema(), other.alt);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.relative_alt)) {
        this.relative_alt = data().deepCopy(fields()[4].schema(), other.relative_alt);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.roll)) {
        this.roll = data().deepCopy(fields()[5].schema(), other.roll);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.pitch)) {
        this.pitch = data().deepCopy(fields()[6].schema(), other.pitch);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.yaw)) {
        this.yaw = data().deepCopy(fields()[7].schema(), other.yaw);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.image_index)) {
        this.image_index = data().deepCopy(fields()[8].schema(), other.image_index);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.capture_result)) {
        this.capture_result = data().deepCopy(fields()[9].schema(), other.capture_result);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.file_url)) {
        this.file_url = data().deepCopy(fields()[10].schema(), other.file_url);
        fieldSetFlags()[10] = true;
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
    public eu.rawfie.uxv.CamCapturedInfo.Builder setHeader(eu.rawfie.uxv.Header value) {
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
    public eu.rawfie.uxv.CamCapturedInfo.Builder setHeaderBuilder(eu.rawfie.uxv.Header.Builder value) {
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
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearHeader() {
      header = null;
      headerBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'lat' field.
      * Latitude where image was taken
      * @return The value.
      */
    public java.lang.Float getLat() {
      return lat;
    }

    /**
      * Sets the value of the 'lat' field.
      * Latitude where image was taken
      * @param value The value of 'lat'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setLat(float value) {
      validate(fields()[1], value);
      this.lat = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'lat' field has been set.
      * Latitude where image was taken
      * @return True if the 'lat' field has been set, false otherwise.
      */
    public boolean hasLat() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'lat' field.
      * Latitude where image was taken
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearLat() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'lon' field.
      * Longitude where image was taken)
      * @return The value.
      */
    public java.lang.Float getLon() {
      return lon;
    }

    /**
      * Sets the value of the 'lon' field.
      * Longitude where image was taken)
      * @param value The value of 'lon'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setLon(float value) {
      validate(fields()[2], value);
      this.lon = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'lon' field has been set.
      * Longitude where image was taken)
      * @return True if the 'lon' field has been set, false otherwise.
      */
    public boolean hasLon() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'lon' field.
      * Longitude where image was taken)
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearLon() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'alt' field.
      * Altitude AMSL (Above Mean Sea Level) where image was taken
      * @return The value.
      */
    public java.lang.Float getAlt() {
      return alt;
    }

    /**
      * Sets the value of the 'alt' field.
      * Altitude AMSL (Above Mean Sea Level) where image was taken
      * @param value The value of 'alt'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setAlt(float value) {
      validate(fields()[3], value);
      this.alt = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'alt' field has been set.
      * Altitude AMSL (Above Mean Sea Level) where image was taken
      * @return True if the 'alt' field has been set, false otherwise.
      */
    public boolean hasAlt() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'alt' field.
      * Altitude AMSL (Above Mean Sea Level) where image was taken
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearAlt() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'relative_alt' field.
      * Altitude above the ground
      * @return The value.
      */
    public java.lang.Float getRelativeAlt() {
      return relative_alt;
    }

    /**
      * Sets the value of the 'relative_alt' field.
      * Altitude above the ground
      * @param value The value of 'relative_alt'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setRelativeAlt(float value) {
      validate(fields()[4], value);
      this.relative_alt = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'relative_alt' field has been set.
      * Altitude above the ground
      * @return True if the 'relative_alt' field has been set, false otherwise.
      */
    public boolean hasRelativeAlt() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'relative_alt' field.
      * Altitude above the ground
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearRelativeAlt() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'roll' field.
      * Camera Roll angle (earth frame, +-180)
      * @return The value.
      */
    public java.lang.Float getRoll() {
      return roll;
    }

    /**
      * Sets the value of the 'roll' field.
      * Camera Roll angle (earth frame, +-180)
      * @param value The value of 'roll'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setRoll(float value) {
      validate(fields()[5], value);
      this.roll = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'roll' field has been set.
      * Camera Roll angle (earth frame, +-180)
      * @return True if the 'roll' field has been set, false otherwise.
      */
    public boolean hasRoll() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'roll' field.
      * Camera Roll angle (earth frame, +-180)
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearRoll() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'pitch' field.
      * Camera Pitch angle (earth frame, +-180)
      * @return The value.
      */
    public java.lang.Float getPitch() {
      return pitch;
    }

    /**
      * Sets the value of the 'pitch' field.
      * Camera Pitch angle (earth frame, +-180)
      * @param value The value of 'pitch'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setPitch(float value) {
      validate(fields()[6], value);
      this.pitch = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'pitch' field has been set.
      * Camera Pitch angle (earth frame, +-180)
      * @return True if the 'pitch' field has been set, false otherwise.
      */
    public boolean hasPitch() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'pitch' field.
      * Camera Pitch angle (earth frame, +-180)
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearPitch() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'yaw' field.
      * Camera Yaw (earth frame, 0-360, true)
      * @return The value.
      */
    public java.lang.Float getYaw() {
      return yaw;
    }

    /**
      * Sets the value of the 'yaw' field.
      * Camera Yaw (earth frame, 0-360, true)
      * @param value The value of 'yaw'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setYaw(float value) {
      validate(fields()[7], value);
      this.yaw = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'yaw' field has been set.
      * Camera Yaw (earth frame, 0-360, true)
      * @return True if the 'yaw' field has been set, false otherwise.
      */
    public boolean hasYaw() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'yaw' field.
      * Camera Yaw (earth frame, 0-360, true)
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearYaw() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'image_index' field.
      * Zero-based index of the image since vehicle armed
      * @return The value.
      */
    public java.lang.Integer getImageIndex() {
      return image_index;
    }

    /**
      * Sets the value of the 'image_index' field.
      * Zero-based index of the image since vehicle armed
      * @param value The value of 'image_index'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setImageIndex(int value) {
      validate(fields()[8], value);
      this.image_index = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'image_index' field has been set.
      * Zero-based index of the image since vehicle armed
      * @return True if the 'image_index' field has been set, false otherwise.
      */
    public boolean hasImageIndex() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'image_index' field.
      * Zero-based index of the image since vehicle armed
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearImageIndex() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'capture_result' field.
      * Indicator for success (1) or failure (0) capturing the image
      * @return The value.
      */
    public java.lang.Integer getCaptureResult() {
      return capture_result;
    }

    /**
      * Sets the value of the 'capture_result' field.
      * Indicator for success (1) or failure (0) capturing the image
      * @param value The value of 'capture_result'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setCaptureResult(int value) {
      validate(fields()[9], value);
      this.capture_result = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'capture_result' field has been set.
      * Indicator for success (1) or failure (0) capturing the image
      * @return True if the 'capture_result' field has been set, false otherwise.
      */
    public boolean hasCaptureResult() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'capture_result' field.
      * Indicator for success (1) or failure (0) capturing the image
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearCaptureResult() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'file_url' field.
      * URL of image taken
      * @return The value.
      */
    public java.lang.String getFileUrl() {
      return file_url;
    }

    /**
      * Sets the value of the 'file_url' field.
      * URL of image taken
      * @param value The value of 'file_url'.
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder setFileUrl(java.lang.String value) {
      validate(fields()[10], value);
      this.file_url = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'file_url' field has been set.
      * URL of image taken
      * @return True if the 'file_url' field has been set, false otherwise.
      */
    public boolean hasFileUrl() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'file_url' field.
      * URL of image taken
      * @return This builder.
      */
    public eu.rawfie.uxv.CamCapturedInfo.Builder clearFileUrl() {
      file_url = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    public CamCapturedInfo build() {
      try {
        CamCapturedInfo record = new CamCapturedInfo();
        if (headerBuilder != null) {
          record.header = this.headerBuilder.build();
        } else {
          record.header = fieldSetFlags()[0] ? this.header : (eu.rawfie.uxv.Header) defaultValue(fields()[0]);
        }
        record.lat = fieldSetFlags()[1] ? this.lat : (java.lang.Float) defaultValue(fields()[1]);
        record.lon = fieldSetFlags()[2] ? this.lon : (java.lang.Float) defaultValue(fields()[2]);
        record.alt = fieldSetFlags()[3] ? this.alt : (java.lang.Float) defaultValue(fields()[3]);
        record.relative_alt = fieldSetFlags()[4] ? this.relative_alt : (java.lang.Float) defaultValue(fields()[4]);
        record.roll = fieldSetFlags()[5] ? this.roll : (java.lang.Float) defaultValue(fields()[5]);
        record.pitch = fieldSetFlags()[6] ? this.pitch : (java.lang.Float) defaultValue(fields()[6]);
        record.yaw = fieldSetFlags()[7] ? this.yaw : (java.lang.Float) defaultValue(fields()[7]);
        record.image_index = fieldSetFlags()[8] ? this.image_index : (java.lang.Integer) defaultValue(fields()[8]);
        record.capture_result = fieldSetFlags()[9] ? this.capture_result : (java.lang.Integer) defaultValue(fields()[9]);
        record.file_url = fieldSetFlags()[10] ? this.file_url : (java.lang.String) defaultValue(fields()[10]);
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
