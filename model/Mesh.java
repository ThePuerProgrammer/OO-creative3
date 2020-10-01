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

    int midX = GamePanel3D.WINDOW_WIDTH / 2;
    int midY = GamePanel3D.WINDOW_HEIGHT / 2;

    private static double scale = 1.0;

    private enum RenderState {
        VECT, TRIS
    }

    private RenderState renderState;

    protected ArrayList<Triangle> triangles;

    public Mesh() {
        triangles = new ArrayList<>();
        renderState = RenderState.TRIS;
    }

    public void addTriangle(Triangle t) {
        triangles.add(t);
    }

    public void renderMesh(Graphics2D g2) {
        int size = 15;
        g2.translate(midX, midY);
        if (renderState == RenderState.VECT) {
            for (var e: triangles) {
                int aX = (int)(e.getA().getX() * scale); 
                int aY = (int)(e.getA().getY() * scale); 
                int bX = (int)(e.getB().getX() * scale); 
                int bY = (int)(e.getB().getY() * scale); 
                int cX = (int)(e.getC().getX() * scale); 
                int cY = (int)(e.getC().getY() * scale); 
                // A
                g2.fillOval(aX, aY, size, size);
                
                // B
                g2.fillOval(bX, bY, size, size);

                // C
                g2.fillOval(cX, cY, size, size);
            }
        }

        if (renderState == RenderState.TRIS) {
            int i = 50;
            for (var e: triangles) {
                g2.setColor(new Color(i/2, i - 10, i + 30));
                i += 10;
                int aX = (int)(e.getA().getX() * scale); 
                int aY = (int)(e.getA().getY() * scale); 
                int bX = (int)(e.getB().getX() * scale); 
                int bY = (int)(e.getB().getY() * scale); 
                int cX = (int)(e.getC().getX() * scale); 
                int cY = (int)(e.getC().getY() * scale); 

                // lines only!
                g2.drawLine(aX, aY, bX, bY);
                g2.drawLine(aX, aY, cX, cY);
                g2.drawLine(bX, bY, cX, cY);

                if (filled) {
                    // FILL THE TRIANGLES!
                    int[] xPoints = {aX, bX, cX};
                    int[] yPoints = {aY, bY, cY};
                    g2.fillPolygon(xPoints, yPoints, 3);
                }
            }
        }
    }

    // The following methods use matrix multiplications for rotation around 0,0,0 
    public void rotateZ(int direction) {
        updateHeading(direction);
        for (var e: triangles) {
            for (var a: e.getVectors()) {  
                double x = (a.getX() * cosTheta) + (a.getY() * -sinTheta) + (a.getZ() * 0);
                double y = ((a.getX() * sinTheta) + (a.getY() * cosTheta) + (a.getZ() * 0));
                double z = ((a.getX() * 0) + (a.getY() * 0) + (a.getZ() * 1));
                a.setVector(x, y, z);
            }
        }

    }

    public void rotateX(int direction) {
        updateHeading(direction);
        for (var e: triangles) {
            for (var a: e.getVectors()) {  
                double x = (a.getX() * 1) + (a.getY() * 0) + (a.getZ() * 0);
                double y = ((a.getX() * 0) + (a.getY() * cosTheta) + (a.getZ() * -sinTheta));
                double z = ((a.getX() * 0) + (a.getY() * sinTheta) + (a.getZ() * cosTheta));
                a.setVector(x, y, z);
            }
        }

    }

    public void rotateY(int direction) {
        updateHeading(direction);
        for (var e: triangles) {
            for (var a: e.getVectors()) {  
                double x = (a.getX() * cosTheta) + (a.getY() * 0) + (a.getZ() * sinTheta);
                double y = ((a.getX() * 0) + (a.getY() * 1) + (a.getZ() * 0));
                double z = ((a.getX() * -sinTheta) + (a.getY() * 0) + (a.getZ() * cosTheta));
                a.setVector(x, y, z);
            }
        }
    }

    private void updateHeading(int direction) {
        assert(direction == -1 || direction == 1);
        int speed = 1;
        if (direction == -1) {
            heading = speed;
        } else {
            heading = -speed;
        }
        cosTheta = Math.cos(Math.toRadians(heading));
        sinTheta = Math.sin(Math.toRadians(heading));
    }

    public static void setFilled(boolean f) {
        filled = f;
    }

    public static void setScale(boolean larger) {
        if (larger) {
            scale += 0.1;
        } else {
            scale -= 0.1;
        }
    }
}
