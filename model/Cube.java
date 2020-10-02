package model;

import java.awt.Color;

public class Cube extends Mesh {

    public Cube() {

        // front -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   new Color(10, 60, 100), "front a"));
           
        // front 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   new Color(60, 150, 30), "front b"));

        // rear -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex( 100.0,  100.0, -100.0),
                                   new Color(100, 30, 90), "rear A"));

        // rear 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  -100.0),
                                   new Vertex( 100.0,  100.0,  -100.0),
                                   new Vertex(-100.0, -100.0,  -100.0),
                                   new Color(60, 130, 210), "rear B"));

        // right 100.0 -100.0                           
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Color(150, 200, 60), "right a"));

        // right 100.0 100.0                          
        triangles.add(new Triangle(new Vertex( 100.0,  100.0, -100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Color(200, 60, 130), "right b"));


        // reversed orientation
        // // right 100.0 -100.0                           
        // triangles.add(new Triangle(new Vertex( 100.0,  100.0,  100.0),
        //                            new Vertex( 100.0,  100.0, -100.0),
        //                            new Vertex( 100.0, -100.0,  100.0),
        //                            new Color(130, 200, 60)));

        // // right 100.0 100.0                          
        // triangles.add(new Triangle(new Vertex( 100.0, -100.0, -100.0),
        //                            new Vertex( 100.0, -100.0,  100.0),
        //                            new Vertex( 100.0,  100.0, -100.0),
        //                            new Color(200, 60, 130)));


        // left -100.0 100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Color(60, 190, 30), "left a"));


        // left -100.0 -100.0                           
        triangles.add(new Triangle(new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Color(30, 60, 100), "left b"));


        // reversed orientation
        // // left -100.0 100.0
        // triangles.add(new Triangle(new Vertex(-100.0,  100.0, -100.0),
        //                            new Vertex(-100.0,  100.0,  100.0),
        //                            new Vertex(-100.0, -100.0, -100.0),
        //                            new Color(60, 100, 30)));


        // // left -100.0 -100.0                           
        // triangles.add(new Triangle(new Vertex(-100.0, -100.0,  100.0),
        //                            new Vertex(-100.0, -100.0, -100.0),
        //                            new Vertex(-100.0,  100.0,  100.0),
        //                            new Color(30, 60, 100)));




        // top -100.0 100.0                    
        triangles.add(new Triangle(new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Color(100, 30, 60), "top a"));

        // top 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0,  100.0, -100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Color(60, 130, 200), "top b"));


        // bottom -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Color(130, 200, 60), "bottom a"));

        // bottom 100.0 -100.0
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Color(200, 60, 130), "bottom b"));
    }
    
    public Cube getCube() {
        return this;
    }
}
