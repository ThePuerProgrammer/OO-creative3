package model;

import java.util.ArrayList;

import view.GamePanel3D;

import java.awt.Graphics2D;
import java.awt.Color;

public class Mesh {

    private double heading;
    private static boolean filled = false;
    private double cosTheta;
    private double sinTheta;

    final private int midX = GamePanel3D.WINDOW_WIDTH / 2;
    final private int midY = GamePanel3D.WINDOW_HEIGHT / 2;

    private static double scale = 1.0;
    private final int shiftSpeed = 5;
    private final int headingSpeed = 3;

    private enum RenderState {
        VERT, TRIS
    }

    private static RenderState renderState;
    protected ArrayList<Triangle> triangles;

    Color[] colors = {
        new Color(0, 100, 0), new Color(0, 0, 100), new Color(100, 0, 0),
        new Color(100, 100, 0), new Color(0, 100, 100), new Color(100, 0, 100),
        new Color(100, 100, 100), new Color(50, 50, 200), new Color(50, 100, 50),
        new Color(100, 50, 50), new Color(100, 100, 50), new Color(50, 100, 100)
    };

    String[] tris = {"FrontA", "FrontB", "RearA", "ReadB", "RightA", "RightB", "LeftA", "LeftB", "TopA", "TopB", "BottomA", "BottomB"};

    public Mesh() {
        triangles = new ArrayList<>();
        renderState = RenderState.VERT;
    }

    public void addTriangle(Triangle t) {
        triangles.add(t);
    }

    public void renderMesh(Graphics2D g2) {
        final int vertSize = 5;
        g2.translate(midX, midY);

        if (renderState == RenderState.VERT) {
            for (var e: triangles) {
                int aX = (int)(e.getA().getX() * scale); 
                int aY = (int)(e.getA().getY() * scale); 
                int bX = (int)(e.getB().getX() * scale); 
                int bY = (int)(e.getB().getY() * scale); 
                int cX = (int)(e.getC().getX() * scale); 
                int cY = (int)(e.getC().getY() * scale); 

                // A
                g2.fillOval(aX, aY, vertSize, vertSize);
                
                // B
                g2.fillOval(bX, bY, vertSize, vertSize);

                // C
                g2.fillOval(cX, cY, vertSize, vertSize);
            }
        }

        if (renderState == RenderState.TRIS) {
            int i = 20;
            for (var e: triangles) {
                Vertex normal = VMath.normalVectorN(e.getA(), e.getB(), e.getC());
                int aX = (int)(e.getA().getX() * scale); 
                int aY = (int)(e.getA().getY() * scale); 
                int aZ = (int)(e.getA().getZ() * scale);
                int bX = (int)(e.getB().getX() * scale); 
                int bY = (int)(e.getB().getY() * scale); 
                int bZ = (int)(e.getB().getZ() * scale); 
                int cX = (int)(e.getC().getX() * scale); 
                int cY = (int)(e.getC().getY() * scale); 
                int cZ = (int)(e.getC().getZ() * scale); 

                if (!filled) {
                    g2.setColor(new Color(50, 40, 200));
                    // lines only!
                    g2.drawLine(aX, aY, bX, bY);
                    g2.drawLine(aX, aY, cX, cY);
                    // g2.drawLine(bX, bY, cX, cY);
                }

                if (filled) {
                    if (normal.getZ() > 0.0) {

                        g2.setColor(e.getColor());
                        i += 15;
                        // FILL THE TRIANGLES! Woo!
                        int[] xPoints = {aX, bX, cX};
                        int[] yPoints = {aY, bY, cY};
                        g2.fillPolygon(xPoints, yPoints, 3);

                        // print coordinates
                        g2.drawString(
                            "aX: " + aX + ", aY: " + aY + ", aZ: " + aZ +
                            ", bX: " + bX + ", bY: " + bY + ", bZ: " + bZ +
                            ", cX: " + cX + ", cY: " + cY + ", cZ: " + cZ, 
                            -390, -390 + i
                        );
                    }
                }
            }
        }
    }

    // The following methods use matrix multiplications for rotation around 0,0,0 
    public void rotateZ(int direction) {
        updateHeading(direction);
        for (var e: triangles) {
            for (var a: e.getVertices()) {  
                double x = (a.getX() * cosTheta) + (a.getY() * -sinTheta) + (a.getZ() * 0);
                double y = ((a.getX() * sinTheta) + (a.getY() * cosTheta) + (a.getZ() * 0));
                double z = ((a.getX() * 0) + (a.getY() * 0) + (a.getZ() * 1));
                a.setVertices(x, y, z);
            }
        }
    }

    public void rotateX(int direction) {
        updateHeading(direction);
        for (var e: triangles) {
            for (var a: e.getVertices()) {  
                double x = (a.getX() * 1) + (a.getY() * 0) + (a.getZ() * 0);
                double y = ((a.getX() * 0) + (a.getY() * cosTheta) + (a.getZ() * -sinTheta));
                double z = ((a.getX() * 0) + (a.getY() * sinTheta) + (a.getZ() * cosTheta));
                a.setVertices(x, y, z);
            }
        }

    }

    public void rotateY(int direction) {
        updateHeading(direction);
        for (var e: triangles) {
            for (var a: e.getVertices()) {  
                double x = (a.getX() * cosTheta) + (a.getY() * 0) + (a.getZ() * sinTheta);
                double y = ((a.getX() * 0) + (a.getY() * 1) + (a.getZ() * 0));
                double z = ((a.getX() * -sinTheta) + (a.getY() * 0) + (a.getZ() * cosTheta));
                a.setVertices(x, y, z);
            }
        }
    }

    // direction of movement
    private void updateHeading(int direction) {
        assert(direction == -1 || direction == 1);
        if (direction == -1) {
            heading = headingSpeed;
        } else {
            heading = -headingSpeed;
        }
        cosTheta = Math.cos(Math.toRadians(heading));
        sinTheta = Math.sin(Math.toRadians(heading));
    }

    public static void setFilled(boolean f) {
        filled = f;
    }

    public static void setScale(boolean larger) {
        if (larger) {
            scale += 0.01;
        } else {
            scale -= 0.01;
        }
    }

    public static void setRenderState(int rS) {
        if (rS == 0) {
            renderState = RenderState.VERT;
        } else if (rS == 1) {
            renderState = RenderState.TRIS;
        }
    }

    // The following shift methods place the vertices further into orbit from (0,0,0)

    public void shiftUp() {
        for (var e: triangles) {
            for (var a: e.getVertices()) {
                a.setVertices(a.getX(), a.getY() - shiftSpeed, a.getZ());
            }
        }
    }

    public void shiftDown() {
        for (var e: triangles) {
            for (var a: e.getVertices()) {
                a.setVertices(a.getX(), a.getY() + shiftSpeed, a.getZ());
            }
        }
    }

    public void shiftLeft() {
        for (var e: triangles) {
            for (var a: e.getVertices()) {
                a.setVertices(a.getX() - shiftSpeed, a.getY(), a.getZ());
            }
        }
    }

    public void shiftRight() {
        for (var e: triangles) {
            for (var a: e.getVertices()) {
                a.setVertices(a.getX() + shiftSpeed, a.getY(), a.getZ());
            }
        }
    }


    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }
}