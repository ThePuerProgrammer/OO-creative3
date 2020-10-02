package model;

public class VMath {

    public VMath() {}

    public static Vertex normalVectorN(Vertex p0, Vertex p1, Vertex p2) {
        double pX = p1.getX() - p0.getX();
        double pY = p1.getY() - p0.getY();
        double pZ = p1.getZ() - p0.getZ();
        double qX = p2.getX() - p0.getX();
        double qY = p2.getY() - p0.getY();
        double qZ = p2.getZ() - p0.getZ();
        double nX = (pY * qZ) - (pZ * qY);
        double nY = (pZ * qX) - (pX * qZ);
        double nZ = (pX * qY) - (pY * qX);
        return new Vertex(nX, nY, nZ);
    }
}