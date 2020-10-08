package model;

public class Sphere extends Mesh {
    
    private final double GOLDEN_RATIO = 1.61803399 * 100;

    // The big leagues
    public Sphere() {

        // bua
        triangles.add(new Triangle(
            new Vertex(      100, -GOLDEN_RATIO,       0),
            new Vertex(        0,    -100,  GOLDEN_RATIO),
            new Vertex(     -100, -GOLDEN_RATIO,       0),
            colors[0])
        );

        // awb
        triangles.add(new Triangle(
            new Vertex(   -100, -GOLDEN_RATIO,       0),
            new Vertex(      0,    -100, -GOLDEN_RATIO),
            new Vertex(    100, -GOLDEN_RATIO,       0),
            colors[1])
        );

        // cbw
        triangles.add(new Triangle(
            new Vertex( GOLDEN_RATIO,       0,    -100),
            new Vertex(    100, -GOLDEN_RATIO,       0),
            new Vertex(      0,    -100, -GOLDEN_RATIO),
            colors[2])
        );

        // wae
        triangles.add(new Triangle(
            new Vertex(      0,    -100, -GOLDEN_RATIO),
            new Vertex(   -100, -GOLDEN_RATIO,       0),
            new Vertex(-GOLDEN_RATIO,       0,    -100),
            colors[3])
        );

        // fuv
        triangles.add(new Triangle(
            new Vertex(-GOLDEN_RATIO,       0,     100),
            new Vertex(      0,    -100,  GOLDEN_RATIO),
            new Vertex(      0,     100,  GOLDEN_RATIO),
            colors[4])
        );

        // fau
        triangles.add(new Triangle(
            new Vertex(-GOLDEN_RATIO,       0,     100),
            new Vertex(   -100, -GOLDEN_RATIO,       0),
            new Vertex(      0,    -100,  GOLDEN_RATIO),
            colors[5])
        );

        // vud
        triangles.add(new Triangle(
            new Vertex(      0,     100,  GOLDEN_RATIO),
            new Vertex(      0,    -100,  GOLDEN_RATIO),
            new Vertex( GOLDEN_RATIO,       0,     100),
            colors[6])
        );

        // yfv
        triangles.add(new Triangle(
            new Vertex(   -100,  GOLDEN_RATIO,       0),
            new Vertex(-GOLDEN_RATIO,       0,     100),
            new Vertex(      0,     100,  GOLDEN_RATIO),
            colors[7])
        );

        // ubd
        triangles.add(new Triangle(
            new Vertex(      0,    -100,  GOLDEN_RATIO),
            new Vertex(    100, -GOLDEN_RATIO,       0),
            new Vertex( GOLDEN_RATIO,       0,     100),
            colors[8])
        );

        // vdz
        triangles.add(new Triangle(
            new Vertex(      0,     100,  GOLDEN_RATIO),
            new Vertex( GOLDEN_RATIO,       0,     100),
            new Vertex(    100,  GOLDEN_RATIO,       0),
            colors[9])
        );

        // yvz
        triangles.add(new Triangle(
            new Vertex(   -100,  GOLDEN_RATIO,       0),
            new Vertex(      0,     100,  GOLDEN_RATIO),
            new Vertex(    100,  GOLDEN_RATIO,       0),
            colors[10])
        );

        // eaf
        triangles.add(new Triangle(
            new Vertex(-GOLDEN_RATIO,       0,    -100),
            new Vertex(   -100, -GOLDEN_RATIO,       0),
            new Vertex(-GOLDEN_RATIO,       0,     100),
            colors[11])
        );

        // yef
        triangles.add(new Triangle(
            new Vertex(   -100,  GOLDEN_RATIO,       0),
            new Vertex(-GOLDEN_RATIO,       0,    -100),
            new Vertex(-GOLDEN_RATIO,       0,     100),
            colors[12])
        );

        // dbc 
        triangles.add(new Triangle(
            new Vertex( GOLDEN_RATIO,       0,     100),
            new Vertex(    100, -GOLDEN_RATIO,       0),
            new Vertex( GOLDEN_RATIO,       0,    -100),
            colors[13])
        );

        // zdc
        triangles.add(new Triangle(
            new Vertex(    100,  GOLDEN_RATIO,       0),
            new Vertex( GOLDEN_RATIO,       0,     100),
            new Vertex( GOLDEN_RATIO,       0,    -100),
            colors[14])
        );

        // yzx
        triangles.add(new Triangle(
            new Vertex(   -100,  GOLDEN_RATIO,       0),
            new Vertex(    100,  GOLDEN_RATIO,       0),
            new Vertex(      0,     100, -GOLDEN_RATIO),
            colors[15])
        );

        // eyx
        triangles.add(new Triangle(
            new Vertex(-GOLDEN_RATIO,       0,    -100),
            new Vertex(   -100,  GOLDEN_RATIO,       0),
            new Vertex(      0,     100, -GOLDEN_RATIO),
            colors[16])
        );

        // wex
        triangles.add(new Triangle(
            new Vertex(      0,    -100, -GOLDEN_RATIO),
            new Vertex(-GOLDEN_RATIO,       0,    -100),
            new Vertex(      0,     100, -GOLDEN_RATIO),
            colors[17])
        );

        // cwx
        triangles.add(new Triangle(
            new Vertex( GOLDEN_RATIO,       0,    -100),
            new Vertex(      0,    -100, -GOLDEN_RATIO),
            new Vertex(      0,     100, -GOLDEN_RATIO),
            colors[18])
        );

        // zcx
        triangles.add(new Triangle(
            new Vertex(    100,  GOLDEN_RATIO,       0),
            new Vertex( GOLDEN_RATIO,       0,    -100),
            new Vertex(      0,     100, -GOLDEN_RATIO),
            colors[19])
        );

        // Vertex u = new Vertex(      0,    -100,  GOLDEN_RATIO);
        // Vertex v = new Vertex(      0,     100,  GOLDEN_RATIO);
        // Vertex w = new Vertex(      0,    -100, -GOLDEN_RATIO);
        // Vertex x = new Vertex(      0,     100, -GOLDEN_RATIO);
        // Vertex y = new Vertex(   -100,  GOLDEN_RATIO,       0);
        // Vertex z = new Vertex(    100,  GOLDEN_RATIO,       0);
        // Vertex a = new Vertex(   -100, -GOLDEN_RATIO,       0);
        // Vertex b = new Vertex(    100, -GOLDEN_RATIO,       0);
        // Vertex c = new Vertex( GOLDEN_RATIO,       0,    -100);
        // Vertex d = new Vertex( GOLDEN_RATIO,       0,     100);
        // Vertex e = new Vertex(-GOLDEN_RATIO,       0,    -100);
        // Vertex f = new Vertex(-GOLDEN_RATIO,       0,     100);
    }
}