package model;

import java.util.ArrayList;
import java.util.Random;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

import view.GamePanel3D;

public class Mesh {

    private double heading;
    private double cosTheta;
    private double sinTheta;
    private double[][] xRotationMatrix;
    private double[][] zRotationMatrix;
    private double[][] yRotationMatrix;
    private int midX = GamePanel3D.WINDOW_WIDTH / 2;
    private int midY = GamePanel3D.WINDOW_HEIGHT / 2;
    private int headingSpeed = 2;
    private Color verticesColor = new Color(0, 220, 110);

    private enum RenderState {
        TRIS, SOLID, VERT
    }

    private static RenderState renderState;
    private static double scale = 1.0;
    public static boolean coordinates = false;
    public static int numOfMeshes = 0;

    private final int SHIFT_SPEED = 5;
    private final int VERT_SIZE = 10;
    private final int VERT_OFFSET = VERT_SIZE / 2;

    protected ArrayList<Triangle> triangles;
    protected Color[] colors;
    protected Random random;

    public Mesh() {
        triangles = new ArrayList<>();
        setRenderState(2);
        colors = new Color[25 * 20];
        random = new Random();

        for (int i = 0; i < 25 * 20; i++) {
            int r = random.nextInt(155) + 100;
            int g = random.nextInt(155) + 100;
            int b = random.nextInt(155) + 100;
            colors[i] = new Color(r, g, b);
        }
        numOfMeshes++;
    }

    public void addTriangle(Triangle t) {
        triangles.add(t);
    }

    public void renderMesh(Graphics2D g2) {
        g2.translate(midX, midY);
        if (renderState == RenderState.VERT) {
            // Verticies only!
            g2.setColor(verticesColor);
            for (var e: triangles) {
                int[] scaled = scaleTriangleVertices(e);
                g2.fillOval(scaled[0] - VERT_OFFSET, scaled[1] - VERT_OFFSET, VERT_SIZE, VERT_SIZE);
                g2.fillOval(scaled[3] - VERT_OFFSET, scaled[4] - VERT_OFFSET, VERT_SIZE, VERT_SIZE);
                g2.fillOval(scaled[6] - VERT_OFFSET, scaled[7] - VERT_OFFSET, VERT_SIZE, VERT_SIZE);
            }
        } else if (renderState == RenderState.TRIS) {
            // lines only!
            for (var e: triangles) {
                g2.setColor(new Color(50, 40, 200));
                int[] scaled = scaleTriangleVertices(e);                
                g2.drawLine(scaled[0], scaled[1], scaled[3], scaled[4]);
                g2.drawLine(scaled[0], scaled[1], scaled[6], scaled[7]);
                g2.drawLine(scaled[3], scaled[4], scaled[6], scaled[7]);
            }
        } else if (renderState == RenderState.SOLID) {
            int i = 5;
            for (var e: triangles) {
                Vertex normal = VMath.normalVectorN(e.getA(), e.getB(), e.getC());
                int[] scaled = scaleTriangleVertices(e);
                if (normal.getZ() > 0.0) {
                    g2.setColor(e.getColor());
                    // FILL THE TRIANGLES! Woo!
                    int[] xPoints = {scaled[0], scaled[3], scaled[6]};
                    int[] yPoints = {scaled[1], scaled[4], scaled[7]};
                    g2.fillPolygon(xPoints, yPoints, 3);
                    // print coordinates
                    if (coordinates) {
                        g2.setFont(new Font("courier", Font.PLAIN, 12));
                        g2.drawString(
                            "aX: " + scaled[0] + ", aY: " + scaled[1] + ", aZ: " + scaled[2] +
                            ", bX: " + scaled[3] + ", bY: " + scaled[4] + ", bZ: " + scaled[5] +
                            ", cX: " + scaled[6] + ", cY: " + scaled[7] + ", cZ: " + scaled[8], 
                            -390, -390 + i
                        );
                        i += 15;
                    }
                }
            }
        }
    }

    public int[] scaleTriangleVertices(Triangle e) {
        int[] result = new int[9];
        result[0] = (int)(e.getA().getX() * scale); 
        result[1] = (int)(e.getA().getY() * scale); 
        result[2] = (int)(e.getA().getZ() * scale);
        result[3] = (int)(e.getB().getX() * scale); 
        result[4] = (int)(e.getB().getY() * scale); 
        result[5] = (int)(e.getB().getZ() * scale); 
        result[6] = (int)(e.getC().getX() * scale); 
        result[7] = (int)(e.getC().getY() * scale); 
        result[8] = (int)(e.getC().getZ() * scale); 
        return result;
    }

    // The following methods use matrix multiplications for rotation around 0,0,0 
    public void rotateZ(int direction) {
        updateHeading(direction);
        rotate(zRotationMatrix);
    }

    public void rotateX(int direction) {
        updateHeading(direction);
        rotate(xRotationMatrix);
    }

    public void rotateY(int direction) {
        updateHeading(direction);
        rotate(yRotationMatrix);
    }

    // relies on VMath for the matrix math to update all vertices
    private void rotate(double[][] matrix) {
        for (var e: triangles) {
            for (var a: e.getVertices()) {  
                double[][] result = VMath.matMul2D(matrix, VMath.convertVertexToMatrix(a));
                a.setVertices(result[0][0], result[1][0], result[2][0]);
            }
        }
    }

    // direction of movement
    private void updateHeading(int direction) {
        assert(direction == -1 || direction == 1);
        if (direction == -1) {
            heading = -headingSpeed;
        } else {
            heading =  headingSpeed;
        }
        cosTheta = Math.cos(Math.toRadians(heading));
        sinTheta = Math.sin(Math.toRadians(heading));
        updateXRotationMatrix();
        updateYRotationMatrix();
        updateZRotationMatrix();
    }

    public void updateZRotationMatrix() {
        double[][] matrix = {
            {cosTheta, -sinTheta, 0},
            {sinTheta,  cosTheta, 0},
            {       0,         0, 1}
        };
        zRotationMatrix = matrix;
    }

    public void updateXRotationMatrix() {
        double[][] matrix = {
            {1,        0,         0},
            {0, cosTheta, -sinTheta},
            {0, sinTheta,  cosTheta}
        };
        xRotationMatrix = matrix;
    }

    public void updateYRotationMatrix() {
        double[][] matrix = {
            { cosTheta, 0, sinTheta},
            {        0, 1,        0},
            {-sinTheta, 0, cosTheta}
        };
        yRotationMatrix = matrix;
    }

    public static void setScale(double s) {
        scale += s;
    }

    public static void resetScale() {
        scale = 1.0;
    }

    public static void setRenderState(int rS) {
        assert (rS >= 0 && rS <= 2);
        if (rS == 2) {
            renderState = RenderState.VERT;
        } else if (rS == 0) {
            renderState = RenderState.TRIS;
        } else if (rS == 1) {
            renderState = RenderState.SOLID;
        }
    }

    // The following shift methods place the vertices further into orbit from (0,0,0)
    public void shiftUp() {
        for (var e: triangles) {
            for (var a: e.getVertices()) {
                a.setVertices(a.getX(), a.getY() - SHIFT_SPEED, a.getZ());
            }
        }
    }

    public void shiftDown() {
        for (var e: triangles) {
            for (var a: e.getVertices()) {
                a.setVertices(a.getX(), a.getY() + SHIFT_SPEED, a.getZ());
            }
        }
    }

    public void shiftLeft() {
        for (var e: triangles) {
            for (var a: e.getVertices()) {
                a.setVertices(a.getX() - SHIFT_SPEED, a.getY(), a.getZ());
            }
        }
    }

    public void shiftRight() {
        for (var e: triangles) {
            for (var a: e.getVertices()) {
                a.setVertices(a.getX() + SHIFT_SPEED, a.getY(), a.getZ());
            }
        }
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public static RenderState getRenderState() {
        return renderState;
    }  
}