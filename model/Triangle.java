package model;

import java.awt.Color;
public class Triangle {
    private Vertex[] vertices;
    Color color;
    String name;

    public Triangle(Vertex a, Vertex b, Vertex c, Color color, String name) {
        vertices = new Vertex[3];
        vertices[0] = a;
        vertices[1] = b;
        vertices[2] = c;
        this.color = color;
        this.name = name;
    }

    public Triangle getTriangle() {
        return this;
    }

    public Vertex getA() {
        return vertices[0];
    }

    public Vertex getB() {
        return vertices[1];
    }

    public Vertex getC() {
        return vertices[2];
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
