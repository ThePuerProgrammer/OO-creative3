package model;

public class Cube extends Mesh {

    public Cube() {

        // front -100 -100
        triangles.add(new Triangle(new Vector(-100, -100,  100),
                                   new Vector(-100,  100,  100),
                                   new Vector( 100, -100,  100)));
           
        // front 100 100
        triangles.add(new Triangle(new Vector( 100,  100,  100),
                                   new Vector( 100, -100,  100),
                                   new Vector(-100,  100,  100)));

        // rear -100 -100
        triangles.add(new Triangle(new Vector(-100, -100,  100),
                                   new Vector(-100,  100,  100),
                                   new Vector( 100, -100,  100)));

        // rear 100 100
        triangles.add(new Triangle(new Vector( 100,  100,  -100),
                                   new Vector( 100, -100,  -100),
                                   new Vector(-100,  100,  -100)));

        // right 100 -100                           
        triangles.add(new Triangle(new Vector( 100, -100,  100),
                                   new Vector( 100,  100,  100),
                                   new Vector( 100, -100, -100)));

        // right 100 100                          
        triangles.add(new Triangle(new Vector( 100,  100, -100),
                                   new Vector(-100, -100, -100),
                                   new Vector( 100,  100,  100)));

        // left -100 -100                           
        triangles.add(new Triangle(new Vector(-100, -100, -100),
                                   new Vector(-100,  100, -100),
                                   new Vector(-100, -100,  100)));

        // left -100 100
        triangles.add(new Triangle(new Vector(-100,  100,  100),
                                   new Vector(-100,  100, -100),
                                   new Vector(-100, -100,  100)));

        // top -100 100                    
        triangles.add(new Triangle(new Vector(-100,  100,  100),
                                   new Vector(-100,  100, -100),
                                   new Vector( 100,  100,  100)));

        // top 100 100
        triangles.add(new Triangle(new Vector( 100,  100, -100),
                                   new Vector( 100,  100,  100),
                                   new Vector(-100,  100, -100)));


        // bottom -100 -100
        triangles.add(new Triangle(new Vector(-100, -100, -100),
                                   new Vector( 100, -100, -100),
                                   new Vector(-100, -100,  100)));

        // bottom 100 -100
        triangles.add(new Triangle(new Vector( 100, -100,  100),
                                   new Vector(-100, -100,  100),
                                   new Vector( 100, -100, -100)));
    }
    
    public Cube getCube() {
        return this;
    }
}
