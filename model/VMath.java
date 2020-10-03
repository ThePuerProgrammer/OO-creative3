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

    // Matrix multiplier!! It works!! :D 
    public double[][] matMul(double[][] matrix, double[][] vertices) {
        double[][] result = new double[vertices.length][vertices[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vertices[0].length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    result[i][j] += matrix[i][k] * vertices[k][j];
                }
            }
        }
        return result;
    }
}