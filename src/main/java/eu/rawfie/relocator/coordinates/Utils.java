package eu.rawfie.relocator.coordinates;

//import pt.lsts.imc.IMCMessage;

/**
 * Created by rasm on 8/3/15.
 */
public class Utils {
    /**
     * Converts the position in EstimatedState messages to WGS-84.
     *
     * @param estimatedState
     * @return
     */
    public static WGS84 toWGS84(Point estimatedState) {

        WGS84 wgs84 = new WGS84(estimatedState.lat,estimatedState.log,estimatedState.height);

        NED ned = new NED(estimatedState.x,estimatedState.y,estimatedState.z);
        // Call the general method.
        return WGS84.displace(wgs84, ned);
    }
}