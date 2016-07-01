package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Eduard on 30.06.2016.
 */
public class Point3D extends Point {
    protected int zPos;
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.zPos = z;
    }
}
