package eu.rawfie.relocator.coordinates;

/**
 * Created by rasm on 8/3/15.
 */
public class NED {
    public double north;
    public double east;
    public double down;

    public NED() {
        this.north = 0;
        this.east = 0;
        this.down = 0;
    }

    public NED(double north, double east, double down) {
        this.north = north;
        this.east = east;
        this.down = down;
    }
}
