package model;

public class Cube extends Mesh {

    public Cube() {

        // front -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   colors[0]));
           
        // front 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex(-100.0, -100.0,  100.0),
                                   colors[0]));

        // rear -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex( 100.0, -100.0, -100.0),
                                   colors[1]));

        // rear 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0,  100.0,  -100.0),
                                   new Vertex( 100.0, -100.0,  -100.0),
                                   new Vertex(-100.0,  100.0,  -100.0),
                                   colors[1]));

        // right 100.0 -100.0                           
        triangles.add(new Triangle(new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex( 100.0,  100.0, -100.0),
                                   colors[2]));

        // right 100.0 100.0                          
        triangles.add(new Triangle(new Vertex( 100.0, -100.0, -100.0),
                                   new Vertex( 100.0,  100.0, -100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   colors[2]));

        // left -100.0 100.0
        triangles.add(new Triangle(new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   colors[3]));

        // left -100.0 -100.0                           
        triangles.add(new Triangle(new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex(-100.0, -100.0, -100.0),
                                   colors[3]));

        // top -100.0 100.0                    
        triangles.add(new Triangle(new Vertex(-100.0, -100.0,  100.0),
                                   new Vertex(-100.0, -100.0, -100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   colors[4]));

        // top 100.0 100.0
        triangles.add(new Triangle(new Vertex( 100.0, -100.0, -100.0),
                                   new Vertex( 100.0, -100.0,  100.0),
                                   new Vertex(-100.0, -100.0, -100.0),
                                   colors[4]));

        // bottom -100.0 -100.0
        triangles.add(new Triangle(new Vertex(-100.0,  100.0, -100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   new Vertex( 100.0,  100.0, -100.0),
                                   colors[5]));

        // bottom 100.0 -100.0
        triangles.add(new Triangle(new Vertex( 100.0,  100.0,  100.0),
                                   new Vertex( 100.0,  100.0, -100.0),
                                   new Vertex(-100.0,  100.0,  100.0),
                                   colors[5]));
    }

    // overloaded constructor for different bounds
    public Cube(int bound) {

        // front -bound -bound
        triangles.add(new Triangle(new Vertex(-bound, -bound,  bound),
                                   new Vertex(-bound,  bound,  bound),
                                   new Vertex( bound, -bound,  bound),
                                   colors[0]));
           
        // front bound bound
        triangles.add(new Triangle(new Vertex( bound,  bound,  bound),
                                   new Vertex( bound, -bound,  bound),
                                   new Vertex(-bound,  bound,  bound),
                                   colors[0]));

        // rear -bound -bound
        triangles.add(new Triangle(new Vertex(-bound,  bound, -bound),
                                   new Vertex(-bound, -bound, -bound),
                                   new Vertex( bound,  bound, -bound),
                                   colors[1]));

        // rear bound bound
        triangles.add(new Triangle(new Vertex( bound, -bound,  -bound),
                                   new Vertex( bound,  bound,  -bound),
                                   new Vertex(-bound, -bound,  -bound),
                                   colors[1]));

        // right bound -bound                           
        triangles.add(new Triangle(new Vertex( bound, -bound,  bound),
                                   new Vertex( bound,  bound,  bound),
                                   new Vertex( bound, -bound, -bound),
                                   colors[2]));

        // right bound bound                          
        triangles.add(new Triangle(new Vertex( bound,  bound, -bound),
                                   new Vertex( bound, -bound, -bound),
                                   new Vertex( bound,  bound,  bound),
                                   colors[2]));

        // left -bound bound
        triangles.add(new Triangle(new Vertex(-bound, -bound, -bound),
                                   new Vertex(-bound,  bound, -bound),
                                   new Vertex(-bound, -bound,  bound),
                                   colors[3]));

        // left -bound -bound                           
        triangles.add(new Triangle(new Vertex(-bound,  bound,  bound),
                                   new Vertex(-bound, -bound,  bound),
                                   new Vertex(-bound,  bound, -bound),
                                   colors[3]));

        // top -bound bound                    
        triangles.add(new Triangle(new Vertex(-bound,  bound,  bound),
                                   new Vertex(-bound,  bound, -bound),
                                   new Vertex( bound,  bound,  bound),
                                   colors[4]));

        // top bound bound
        triangles.add(new Triangle(new Vertex( bound,  bound, -bound),
                                   new Vertex( bound,  bound,  bound),
                                   new Vertex(-bound,  bound, -bound),
                                   colors[4]));

        // bottom -bound -bound
        triangles.add(new Triangle(new Vertex(-bound, -bound, -bound),
                                   new Vertex(-bound, -bound,  bound),
                                   new Vertex( bound, -bound, -bound),
                                   colors[5]));

        // bottom bound -bound
        triangles.add(new Triangle(new Vertex( bound, -bound,  bound),
                                   new Vertex( bound, -bound, -bound),
                                   new Vertex(-bound, -bound,  bound),
                                   colors[5]));
    }
    
    public Cube getCube() {
        return this;
    }
}
