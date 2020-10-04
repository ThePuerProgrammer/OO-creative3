package model;

public class Sphere extends Mesh {
    
    private final double PI = 3.141592653589;
    private final double RADIUS = 100.0;
    private final double CIRCUMFERENCE = 2 * PI * RADIUS;
    private final double GOLDEN = 1.61803399 * 100;

    // The big leagues
    public Sphere() {
        triangles.add(new Triangle(
            new Vertex(      100, -GOLDEN,       0),
            new Vertex(        0,    -100,  GOLDEN),
            new Vertex(     -100, -GOLDEN,       0),
            colors[0])
        );

        // awb
        triangles.add(new Triangle(
            new Vertex(   -100, -GOLDEN,       0),
            new Vertex(      0,    -100, -GOLDEN),
            new Vertex(    100, -GOLDEN,       0),
            colors[1])
        );

        // cbw
        triangles.add(new Triangle(
            new Vertex( GOLDEN,       0,    -100),
            new Vertex(    100, -GOLDEN,       0),
            new Vertex(      0,    -100, -GOLDEN),
            colors[2])
        );

        // wae
        triangles.add(new Triangle(
            new Vertex(      0,    -100, -GOLDEN),
            new Vertex(   -100, -GOLDEN,       0),
            new Vertex(-GOLDEN,       0,    -100),
            colors[3])
        );

        // fuv
        triangles.add(new Triangle(
            new Vertex(-GOLDEN,       0,     100),
            new Vertex(      0,    -100,  GOLDEN),
            new Vertex(      0,     100,  GOLDEN),
            colors[4])
        );

        // fau
        triangles.add(new Triangle(
            new Vertex(-GOLDEN,       0,     100),
            new Vertex(   -100, -GOLDEN,       0),
            new Vertex(      0,    -100,  GOLDEN),
            colors[5])
        );

        // vud
        triangles.add(new Triangle(
            new Vertex(      0,     100,  GOLDEN),
            new Vertex(      0,    -100,  GOLDEN),
            new Vertex( GOLDEN,       0,     100),
            colors[6])
        );

        // yfv
        triangles.add(new Triangle(
            new Vertex(   -100,  GOLDEN,       0),
            new Vertex(-GOLDEN,       0,     100),
            new Vertex(      0,     100,  GOLDEN),
            colors[7])
        );

        // ubd
        triangles.add(new Triangle(
            new Vertex(      0,    -100,  GOLDEN),
            new Vertex(    100, -GOLDEN,       0),
            new Vertex( GOLDEN,       0,     100),
            colors[8])
        );

        // vdz
        triangles.add(new Triangle(
            new Vertex(      0,     100,  GOLDEN),
            new Vertex( GOLDEN,       0,     100),
            new Vertex(    100,  GOLDEN,       0),
            colors[9])
        );

        // yvz
        triangles.add(new Triangle(
            new Vertex(   -100,  GOLDEN,       0),
            new Vertex(      0,     100,  GOLDEN),
            new Vertex(    100,  GOLDEN,       0),
            colors[10])
        );

        // eaf
        triangles.add(new Triangle(
            new Vertex(-GOLDEN,       0,    -100),
            new Vertex(   -100, -GOLDEN,       0),
            new Vertex(-GOLDEN,       0,     100),
            colors[11])
        );
        // yef
        triangles.add(new Triangle(
            new Vertex(   -100,  GOLDEN,       0),
            new Vertex(-GOLDEN,       0,    -100),
            new Vertex(-GOLDEN,       0,     100),
            colors[12])
        );

        // dbc 
        triangles.add(new Triangle(
            new Vertex( GOLDEN,       0,     100),
            new Vertex(    100, -GOLDEN,       0),
            new Vertex( GOLDEN,       0,    -100),
            colors[13])
        );
        // zdc
        triangles.add(new Triangle(
            new Vertex(    100,  GOLDEN,       0),
            new Vertex( GOLDEN,       0,     100),
            new Vertex( GOLDEN,       0,    -100),
            colors[14])
        );
        // yzx
        triangles.add(new Triangle(
            new Vertex(   -100,  GOLDEN,       0),
            new Vertex(    100,  GOLDEN,       0),
            new Vertex(      0,     100, -GOLDEN),
            colors[15])
        );
        // eyx
        triangles.add(new Triangle(
            new Vertex(-GOLDEN,       0,    -100),
            new Vertex(   -100,  GOLDEN,       0),
            new Vertex(      0,     100, -GOLDEN),
            colors[16])
        );
        // wex
        triangles.add(new Triangle(
            new Vertex(      0,    -100, -GOLDEN),
            new Vertex(-GOLDEN,       0,    -100),
            new Vertex(      0,     100, -GOLDEN),
            colors[17])
        );
        // cwx
        triangles.add(new Triangle(
            new Vertex( GOLDEN,       0,    -100),
            new Vertex(      0,    -100, -GOLDEN),
            new Vertex(      0,     100, -GOLDEN),
            colors[18])
        );
        // zcx
        triangles.add(new Triangle(
            new Vertex(    100,  GOLDEN,       0),
            new Vertex( GOLDEN,       0,    -100),
            new Vertex(      0,     100, -GOLDEN),
            colors[19])
        );

        // Vertex u = new Vertex(      0,    -100,  GOLDEN);
        // Vertex v = new Vertex(      0,     100,  GOLDEN);
        // Vertex w = new Vertex(      0,    -100, -GOLDEN);
        // Vertex x = new Vertex(      0,     100, -GOLDEN);
        // Vertex y = new Vertex(   -100,  GOLDEN,       0);
        // Vertex z = new Vertex(    100,  GOLDEN,       0);
        // Vertex a = new Vertex(   -100, -GOLDEN,       0);
        // Vertex b = new Vertex(    100, -GOLDEN,       0);
        // Vertex c = new Vertex( GOLDEN,       0,    -100);
        // Vertex d = new Vertex( GOLDEN,       0,     100);
        // Vertex e = new Vertex(-GOLDEN,       0,    -100);
        // Vertex f = new Vertex(-GOLDEN,       0,     100);

    }
}