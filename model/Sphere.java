package model;

public class Sphere extends Mesh {
    
    private final double PI = 3.141592653589;
    private final double RADIUS = 100.0;
    private final double CIRCUMFERENCE = 2 * PI * RADIUS;

    // The big leagues
    public Sphere() {

        triangles.add(new Triangle(
            new Vertex(-RADIUS,  RADIUS,  RADIUS),
            new Vertex(      0, -RADIUS,  RADIUS),
            new Vertex(-RADIUS,  RADIUS,  RADIUS)
        ));

        triangles.add(new Triangle(
            new Vertex(-RADIUS,  RADIUS,  RADIUS),
            new Vertex(      0, -RADIUS,  RADIUS),
            new Vertex(-RADIUS,  RADIUS,  RADIUS)
        ));
    }
}