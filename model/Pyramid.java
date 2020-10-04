package model;

public class Pyramid extends Mesh {
    
    public Pyramid() {
        // front face
        triangles.add(new Triangle(
            new Vertex(-100,  100,  100),
            new Vertex(   0, -100,    0),
            new Vertex( 100,  100,  100),
            colors[0]
        ));
        // left face
        triangles.add(new Triangle(
            new Vertex(-100,  100, -100),
            new Vertex(   0, -100,    0),
            new Vertex(-100,  100,  100),
            colors[1]
        ));
        // rear face
        triangles.add(new Triangle(
            new Vertex( 100,  100, -100),
            new Vertex(   0, -100,    0),
            new Vertex(-100,  100, -100),
            colors[2]
        ));
        // right face
        triangles.add(new Triangle(
            new Vertex( 100,  100,  100),
            new Vertex(   0, -100,    0),
            new Vertex( 100,  100, -100),
            colors[3]
        ));
        // bottom a
        triangles.add(new Triangle(
            new Vertex( 100,  100,  100),
            new Vertex(-100,  100, -100),
            new Vertex(-100,  100,  100),
            colors[4]
        ));
        // bottom b
        triangles.add(new Triangle(
            new Vertex(-100,  100, -100),
            new Vertex( 100,  100,  100),
            new Vertex( 100,  100, -100),
            colors[5]
        ));
    }

    public Pyramid getPyramid() {
        return this;
    }
}
