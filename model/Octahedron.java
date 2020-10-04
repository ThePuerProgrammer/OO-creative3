package model;

public class Octahedron extends Mesh {
    
    public Octahedron() {
        // front face
        triangles.add(new Triangle(
            new Vertex(-100,    0,  100),
            new Vertex(   0, -100,    0),
            new Vertex( 100,    0,  100),
            colors[0]
        ));
        // left face
        triangles.add(new Triangle(
            new Vertex(-100,    0, -100),
            new Vertex(   0, -100,    0),
            new Vertex(-100,    0,  100),
            colors[1]
        ));
        // rear face
        triangles.add(new Triangle(
            new Vertex( 100,    0, -100),
            new Vertex(   0, -100,    0),
            new Vertex(-100,    0, -100),
            colors[2]
        ));
        // right face
        triangles.add(new Triangle(
            new Vertex( 100,    0,  100),
            new Vertex(   0, -100,    0),
            new Vertex( 100,    0, -100),
            colors[3]
        ));
        // bottom face
        triangles.add(new Triangle(
            new Vertex( 100,    0,  100),
            new Vertex(   0,  100,    0),
            new Vertex(-100,    0,  100),
            colors[4]
        ));
        // bottom left
        triangles.add(new Triangle(
            new Vertex(-100,    0,  100),
            new Vertex(   0,  100,    0),
            new Vertex(-100,    0, -100),
            colors[5]
        ));
        // bottom rear
        triangles.add(new Triangle(
            new Vertex(-100,    0, -100),
            new Vertex(   0,  100,    0),
            new Vertex( 100,    0, -100),
            colors[6]
        ));
        // bottom right
        triangles.add(new Triangle(
            new Vertex( 100,    0, -100),
            new Vertex(   0,  100,    0),
            new Vertex( 100,    0,  100),
            colors[7]
        ));
    }

    public Octahedron getOctahedron() {
        return this;
    }
}
