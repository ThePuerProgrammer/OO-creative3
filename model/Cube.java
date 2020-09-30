package model;

public class Cube extends Mesh {

    public Cube() {

        // front -100.0 -100.0
        triangles.add(new Triangle(new Vector(-100.0, -100.0,  100.0),
                                   new Vector(-100.0,  100.0,  100.0),
                                   new Vector( 100.0, -100.0,  100.0)));
           
        // front 100.0 100.0
        triangles.add(new Triangle(new Vector( 100.0,  100.0,  100.0),
                                   new Vector( 100.0, -100.0,  100.0),
                                   new Vector(-100.0,  100.0,  100.0)));

        // rear -100.0 -100.0
        triangles.add(new Triangle(new Vector(-100.0,  100.0, -100.0),
                                   new Vector( 100.0,  100.0, -100.0),
                                   new Vector(-100.0, -100.0, -100.0)));

        // rear 100.0 100.0
        triangles.add(new Triangle(new Vector( 100.0, -100.0,  -100.0),
                                   new Vector(-100.0, -100.0,  -100.0),
                                   new Vector( 100.0,  100.0,  -100.0)));

        // right 100.0 -100.0                           
        triangles.add(new Triangle(new Vector( 100.0, -100.0,  100.0),
                                   new Vector( 100.0,  100.0,  100.0),
                                   new Vector( 100.0, -100.0, -100.0)));

        // right 100.0 100.0                          
        triangles.add(new Triangle(new Vector( 100.0,  100.0, -100.0),
                                   new Vector( 100.0, -100.0, -100.0),
                                   new Vector( 100.0,  100.0,  100.0)));

        // left -100.0 -100.0                           
        triangles.add(new Triangle(new Vector(-100.0, -100.0, -100.0),
                                   new Vector(-100.0,  100.0, -100.0),
                                   new Vector(-100.0, -100.0,  100.0)));

        // left -100.0 100.0
        triangles.add(new Triangle(new Vector(-100.0,  100.0,  100.0),
                                   new Vector(-100.0, -100.0,  100.0),
                                   new Vector(-100.0,  100.0, -100.0)));

        // top -100.0 100.0                    
        triangles.add(new Triangle(new Vector(-100.0,  100.0,  100.0),
                                   new Vector(-100.0,  100.0, -100.0),
                                   new Vector( 100.0,  100.0,  100.0)));

        // top 100.0 100.0
        triangles.add(new Triangle(new Vector( 100.0,  100.0, -100.0),
                                   new Vector( 100.0,  100.0,  100.0),
                                   new Vector(-100.0,  100.0, -100.0)));


        // bottom -100.0 -100.0
        triangles.add(new Triangle(new Vector(-100.0, -100.0, -100.0),
                                   new Vector( 100.0, -100.0, -100.0),
                                   new Vector(-100.0, -100.0,  100.0)));

        // bottom 100.0 -100.0
        triangles.add(new Triangle(new Vector( 100.0, -100.0,  100.0),
                                   new Vector(-100.0, -100.0,  100.0),
                                   new Vector( 100.0, -100.0, -100.0)));
    }
    
    public Cube getCube() {
        return this;
    }
}
