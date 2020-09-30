package model;

import java.util.ArrayList;

import view.GamePanel3D;

import java.awt.Graphics2D;
import java.awt.Color;

public class Mesh {

    private int heading = 180;

    private Matrix matrix;

    int midX = GamePanel3D.WINDOW_WIDTH / 2;
    int midY = GamePanel3D.WINDOW_HEIGHT / 2;

    private Color[] colors = {
        Color.RED, Color.BLUE, Color.WHITE, Color.CYAN, Color.GREEN, Color.ORANGE,
        Color.RED, Color.BLUE, Color.WHITE, Color.CYAN, Color.GREEN, Color.ORANGE
    };

    private int scale = 1;

    private enum RenderState {
        VECT, TRIS
    }

    private RenderState renderState;

    protected ArrayList<Triangle> triangles;

    public Mesh() {
        triangles = new ArrayList<>();
        renderState = RenderState.TRIS;
        matrix = new Matrix();
    }

    public void addTriangle(Triangle t) {
        triangles.add(t);
    }

    public void renderMesh(Graphics2D g2) {
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
                g2.fillOval(aX, aY, 3, 3);
                
                // B
                g2.fillOval(bX, bY, 3, 3);

                // C
                g2.fillOval(cX, cY, 3, 3);
            }
        }

        if (renderState == RenderState.TRIS) {
            g2.setColor(Color.white);
            int i = 0;
            for (var e: triangles) {
                // g2.setColor(colors[i]);
                // i++;
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

                // // FILL THE TRIANGLES!
                // int[] xPoints = {aX, bX, cX};
                // int[] yPoints = {aY, bY, cY};
                // g2.fillPolygon(xPoints, yPoints, 3);
            }
        }
    }

    public void rotateXY(int direction) {
        assert(direction == -1 || direction == 1);

    }

    public void rotateYZ(int direction) {
        assert(direction == -1 || direction == 1);

    }

    public void rotateXZ(int direction) {
        assert(direction == -1 || direction == 1);

        if (direction == -1) {
            heading -= 1;
        } else {
            heading += 1;
        }

        if (heading > 360) {
            heading = 0;
        } else if (heading < 0) {
            heading = 360;
        }

        double cosTheta = Math.cos(Math.toRadians(heading));
        double sinTheta = Math.sin(Math.toRadians(heading));
        
        // double[][] aY = {
        //     {cosTheta, 0, -sinTheta},
        //     {0, 1, 0},
        //     {sinTheta, 0, cosTheta}
        // };

        for (var e: triangles) {
            for (var a: e.getVectors()) {  
                double x = (a.getX() * cosTheta) + (a.getY() * 0) + (a.getZ() * sinTheta);
                double y = ((a.getX() * 0) + (a.getY() * 1) + (a.getZ() * 0));
                double z = ((a.getX() * -sinTheta) + (a.getY() * 0) + (a.getZ() * cosTheta));
                a.setVector(x, y, z);
            }
        }
    }
}
