package eu.rawfie.relocator.coordinates;

public class ECEF {
    public double x;
    public double y;
    public double z;

    public ECEF() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public ECEF(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
