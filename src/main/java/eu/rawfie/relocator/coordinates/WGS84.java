package eu.rawfie.relocator.coordinates;

/**
 * Created by rasm on 8/3/15.
 */
public class WGS84 {
    //! Semi-major axis.
    private static final double c_wgs84_a = 6378137.0;
    //! First eccentricity squared.
    private static final double c_wgs84_e2 = 0.00669437999013;


    public double latitude;
    public double longitude;
    public double height;

    public WGS84() {
        this.latitude = 0;
        this.longitude = 0;
        this.height = 0;
    }

    public WGS84(double latitude, double longitude, double height) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    /**
     * Computes the distance between two WGS-84 coordinates.
     *
     * @param pointA first WGS-84 coordinate.
     * @param pointB second WGS-84 coordinate.
     * @return distance in meter.
     */
    public static double distance(WGS84 pointA, WGS84 pointB) {
        ECEF ecefA = toECEF(pointA);
        ECEF ecefB = toECEF(pointB);

        double x = ecefA.x -= ecefB.x;
        double y = ecefA.y -= ecefB.y;
        double z = ecefA.z -= ecefB.z;

        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Compute North-East-Down displacement between two WGS-84
     * coordinates.
     *
     * @param pointA WGS-84 coordinates of point A.
     * @param pointB WGS-84 coordinates of point B.
     * @return displacement in North-East-Down coordinates.
     */
    public static NED displacement(WGS84 pointA, WGS84 pointB) {
        ECEF ecefA = toECEF(pointA);
        ECEF ecefB = toECEF(pointB);

        double ox = ecefB.x - ecefA.x;
        double oy = ecefB.y - ecefA.y;
        double oz = ecefB.z - ecefA.z;
        double slat = Math.sin(pointA.latitude);
        double clat = Math.cos(pointA.latitude);
        double slon = Math.sin(pointA.longitude);
        double clon = Math.cos(pointA.longitude);

        NED ned = new NED();
        ned.north = -slat * clon * ox - slat * slon * oy + clat * oz;
        ned.east = -slon * ox + clon * oy;
        ned.down = -clat * clon * ox - clat * slon * oy - slat * oz;

        return ned;
    }

    /**
     * Displace a WGS-84 coordinate in the NED frame
     * according to given offsets.
     *
     * @param north North offset (m).
     * @param east  East offset (m).
     * @param down  Down offset (m).
     * @param lat   reference latitude on entry, displaced
     *              latitude on exit (rad).
     * @param lon   reference longitude entry, displaced
     *              longitude on exit (rad).
     * @param hae   reference height on entry, displaced
     *              height on exit (rad).
     */
    public static WGS84 displace(WGS84 wgs84, NED ned) {
        ECEF ecef = toECEF(wgs84);

        // Compute Geocentric latitude.
        double phi = Math.atan2(ecef.z, Math.sqrt(ecef.x * ecef.x + ecef.y * ecef.y));

        // Compute all needed sine and cosine terms for conversion.
        double slon = Math.sin(wgs84.longitude);
        double clon = Math.cos(wgs84.longitude);
        double sphi = Math.sin(phi);
        double cphi = Math.cos(phi);

        // Obtain ECEF coordinates of displaced point
        // Note: some signs from standard ENU formula
        // are inverted - we are working with NED (= END) coordinates
        ecef.x += -slon * ned.east - clon * sphi * ned.north - clon * cphi * ned.down;
        ecef.y += clon * ned.east - slon * sphi * ned.north - slon * cphi * ned.down;
        ecef.z += cphi * ned.north - sphi * ned.down;

        // Convert back to WGS-84 coordinates.
        return fromECEF(ecef);
    }

    //! Convert WGS-84 coordinates to ECEF (Earth Center Earth Fixed) coordinates.
    //!
    //! @param[in] lat WGS-84 latitude (rad).
    //! @param[in] lon WGS-84 longitude (rad).
    //! @param[in] hae WGS-84 coordinate height (m).
    //! @param[out] x storage for ECEF x coordinate (m).
    //! @param[out] y storage for ECEF y coordinate (m).
    //! @param[out] z storage for ECEF z coordinate (m).
    public static ECEF toECEF(WGS84 wgs84) {
        double cos_lat = Math.cos(wgs84.latitude);
        double sin_lat = Math.sin(wgs84.latitude);
        double cos_lon = Math.cos(wgs84.longitude);
        double sin_lon = Math.sin(wgs84.longitude);
        double rn = computeRn(wgs84.latitude);

        ECEF ecef = new ECEF();
        ecef.x = (rn + wgs84.height) * cos_lat * cos_lon;
        ecef.y = (rn + wgs84.height) * cos_lat * sin_lon;
        ecef.z = (((1.0 - c_wgs84_e2) * rn) + wgs84.height) * sin_lat;
        return ecef;
    }

    /**
     * Convert ECEF (x,y,z) to WGS-84 (lat, lon, hae).
     *
     * @param ecef ECEF coordinates.
     */
    public static WGS84 fromECEF(ECEF ecef) {
        WGS84 wgs84 = new WGS84();

        double p = Math.sqrt(ecef.x * ecef.x + ecef.y * ecef.y);

        wgs84.longitude = Math.atan2(ecef.y, ecef.x);
        wgs84.latitude = Math.atan2(ecef.z / p, 0.01);
        double n = computeRn(wgs84.latitude);
        wgs84.height = p / Math.cos(wgs84.latitude) - n;
        double old_hae = -1e-9;
        double num = ecef.z / p;

        while (Math.abs(wgs84.height - old_hae) > 1e-4) {
            old_hae = wgs84.height;
            double den = 1 - c_wgs84_e2 * n / (n + wgs84.height);
            wgs84.latitude = Math.atan2(num, den);
            n = computeRn(wgs84.latitude);
            wgs84.height = p / Math.cos(wgs84.latitude) - n;
        }

        return wgs84;
    }

    private static double computeRn(double lat) {
        double lat_sin = Math.sin(lat);
        return c_wgs84_a / Math.sqrt(1 - c_wgs84_e2 * (lat_sin * lat_sin));
    }

    public static void main(String[] args) {
        WGS84 a = new WGS84(0.718775526673872, -0.15189344194764262, -1.6717882);
        NED n = new NED(0, 0, 0);
        WGS84 x = displace(a, n);
        System.err.format("%.12f, %.12f, %.12f\n", x.latitude - a.latitude, x.longitude - a.longitude, x.height - a.height);
    }
}
