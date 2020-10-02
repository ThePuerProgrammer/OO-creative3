package model;

import java.awt.Color;
import java.util.Random;

public class Cube extends Mesh {

    public Cube() {

        Color[] colors = new Color[6];
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(155) + 100;
            int g = random.nextInt(155) + 100;
            int b = random.nextInt(155) + 100;
            colors[i] = new Color(r, g, b);
        }

        // front -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   colors[0]));
           
        // front 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   colors[0]));

        // rear -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex( 100.0,  100.0, -100.0),
                                   colors[1]));

        // rear 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  -100.0),
                                   new Vertex( 100.0,  100.0,  -100.0),
                                   new Vertex(-100.0, -100.0,  -100.0),
                                   colors[1]));

        // right 100.0 -100.0                           
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   colors[2]));

        // right 100.0 100.0                          
        triangles.add(new Triangle(new Vertex( 100.0,  100.0, -100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   colors[2]));

        // left -100.0 100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   colors[3]));

        // left -100.0 -100.0                           
        triangles.add(new Triangle(new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   colors[3]));

        // top -100.0 100.0                    
        triangles.add(new Triangle(new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   colors[4]));

        // top 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0,  100.0, -100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   colors[4]));

        // bottom -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   colors[5]));

        // bottom 100.0 -100.0
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   colors[5]));
    }
    
    public Cube getCube() {
        return this;
    }
}
