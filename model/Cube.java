package model;

import java.awt.Color;

public class Cube extends Mesh {

    public Cube() {

        // front -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   new Color(10, 60, 100)));
           
        // front 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   new Color(60, 150, 30)));

        // rear -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex( 100.0,  100.0, -100.0),
                                   new Color(100, 30, 90)));

        // rear 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  -100.0),
                                   new Vertex( 100.0,  100.0,  -100.0),
                                   new Vertex(-100.0, -100.0,  -100.0),
                                   new Color(60, 130, 210)));

        // right 100.0 -100.0                           
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Color(150, 200, 60)));

        // right 100.0 100.0                          
        triangles.add(new Triangle(new Vertex( 100.0,  100.0, -100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Color(200, 60, 130)));

        // left -100.0 100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Color(60, 190, 30)));

        // left -100.0 -100.0                           
        triangles.add(new Triangle(new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Color(30, 60, 100)));

        // top -100.0 100.0                    
        triangles.add(new Triangle(new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Color(100, 30, 60)));

        // top 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0,  100.0, -100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Color(60, 130, 200)));

        // bottom -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Color(130, 200, 60)));

        // bottom 100.0 -100.0
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Color(200, 60, 130)));
    }
    
    public Cube getCube() {
        return this;
    }
}
