package model;

public class Triangle {
    private Vector[] vectors;

    public Triangle(Vector a, Vector b, Vector c) {
        vectors = new Vector[3];
        vectors[0] = a;
        vectors[1] = b;
        vectors[2] = c;
    }

    public Triangle getTriangle() {
        return this;
    }

    public Vector getA() {
        return vectors[0];
    }

    public Vector getB() {
        return vectors[1];
    }

    public Vector getC() {
        return vectors[2];
    }

    public Vector[] getVectors() {
        return vectors;
    }
}
