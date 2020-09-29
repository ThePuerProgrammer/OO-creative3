package model;

import java.util.ArrayList;

import view.GamePanel3D;

import java.awt.Graphics2D;
import java.awt.Color;

public class Mesh {

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
        if (renderState == RenderState.VECT) {
            for (var e: triangles) {
                int aX = midX + (e.getA().getX() * scale); 
                int aY = midY + (e.getA().getY() * scale); 
                int bX = midX + (e.getB().getX() * scale); 
                int bY = midY + (e.getB().getY() * scale); 
                int cX = midX + (e.getC().getX() * scale); 
                int cY = midY + (e.getC().getY() * scale); 
                // A
                g2.fillOval(aX, aY, 3, 3);
                
                // B
                g2.fillOval(bX, bY, 3, 3);

                // C
                g2.fillOval(cX, cY, 3, 3);
            }
        }

        if (renderState == RenderState.TRIS) {
            int i = 0;
            for (var e: triangles) {
                g2.setColor(colors[i]);
                i++;
                int aX = midX + (e.getA().getX() * scale); 
                int aY = midY + (e.getA().getY() * scale); 
                int bX = midX + (e.getB().getX() * scale); 
                int bY = midY + (e.getB().getY() * scale); 
                int cX = midX + (e.getC().getX() * scale); 
                int cY = midY + (e.getC().getY() * scale); 
                g2.drawLine(aX, aY, bX, bY);
                g2.drawLine(aX, aY, cX, cY);
                g2.drawLine(bX, bY, cX, cY);

                // FILL THE TRIANGLES!
                // int[] xPoints = {aX, bX, cX};
                // int[] yPoints = {aY, bY, cY};
                // g2.fillPolygon(xPoints, yPoints, 3);
            }
        }
    }

    public void rotateXY(int direction) {
        assert(direction == -1 || direction == 1);
        for (var e: triangles) {
            for (var a: e.getVectors()) {
                if (direction == -1) {

                } else {

                }
            }
        }
    }

    public void rotateYZ(int direction) {
        assert(direction == -1 || direction == 1);
        if (direction == -1) {

        } else {
            
        }
    }

    public void rotateXZ(int direction) {
        assert(direction == -1 || direction == 1);
        for (var e: triangles) {
            for (var a: e.getVectors()) {

                int x = a.getX();
                int y = a.getY();
                int z = a.getZ();
                
                double lengthC = java.lang.Math.sqrt(
                    java.lang.Math.pow(a.getX() - midX, 2) +
                    java.lang.Math.pow(a.getY() - midY, 2)
                );

                System.out.println("C: " + lengthC);
                if (direction == -1) {

                } else {
                    
                }
            }
        }
    }
}
