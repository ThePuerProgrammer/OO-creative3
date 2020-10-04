package view;

import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Font;

import model.Cube;
import model.Mesh;
import model.Octahedron;
import model.Sphere;

public class GameCanvas3D extends JPanel {
    private String fps = "hi";
    private String vertices = "";
    private static final long serialVersionUID = 1L;
    private ArrayList<Mesh> meshes;
    private GamePanel3D gamePanel3D;
    private Graphics2D g2;
    
    private final int[] TRIANGLE_ICON_X = {740, 765, 790};
    private final int[] TRIANGLE_ICON_Y = {790, 740, 790};

    public static Color squareIconColor;
    public static Color triangleIconColor;
    public static Color sphereIconColor;
    public static Color wireframeColor;
    public static Color solidColor;
    public static Color vertexOnlyColor;

    public GameCanvas3D(GamePanel3D gamePanel3D) {
        this.gamePanel3D = gamePanel3D;
        setPreferredSize(new Dimension(GamePanel3D.WINDOW_WIDTH, GamePanel3D.WINDOW_HEIGHT));
        setBackground(new Color(0 , 0, 10));
        meshes = new ArrayList<>();
        meshes.add(new Cube());
        sphereIconColor = triangleIconColor = squareIconColor = new Color(20, 150, 160);
        vertexOnlyColor = solidColor = wireframeColor = Color.RED;
    } 

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;

        g2.setColor(Color.RED);
        g2.setFont(new Font("Courier", Font.PLAIN, 12));
        g2.drawString(fps, 10, 10);
        g2.drawString(vertices, 10, 24);

        g2.setColor(wireframeColor);
        g2.drawRect(10, 740, 50, 50);
        g2.setColor(solidColor);
        g2.fillRect(70, 740, 50, 50);
        g2.setColor(vertexOnlyColor);
        g2.fillOval(130, 740, 5, 5);
        g2.fillOval(150, 740, 5, 5);
        g2.fillOval(175, 740, 5, 5);
        g2.fillOval(175, 760, 5, 5);
        g2.fillOval(175, 785, 5, 5);
        g2.fillOval(150, 785, 5, 5);
        g2.fillOval(130, 785, 5, 5);
        g2.fillOval(130, 760, 5, 5);

        g2.setColor(triangleIconColor);
        g2.fillPolygon(TRIANGLE_ICON_X, TRIANGLE_ICON_Y, 3);
        g2.setColor(squareIconColor);
        g2.fillRect(680, 740, 50, 50);
        g2.setColor(sphereIconColor);
        g2.fillOval(620, 740, 50, 50);


        for (var e: meshes) {
            e.renderMesh(g2);
        }

    }

    public ArrayList<Mesh> getMeshes() {
        return meshes;
    }

    public void rUp() {
        for (var e: meshes) {
            e.rotateX(1);
        }
    }

    public void rDown() {
        for (var e: meshes) {
            e.rotateX(-1);
        }
    }

    public void rLeft() {
        for (var e: meshes) {
            e.rotateY(-1);
        }
    }

    public void rRight() {
        for (var e: meshes) {
            e.rotateY(1);
        }
    }

    public void rClockwise() {
        for (var e: meshes) {
            e.rotateZ(-1);
        }
    }

    public void rCounterClockwise() {
        for (var e: meshes) {
            e.rotateZ(1);
        }
    }

    public void shiftUp() {
        for (var m: meshes) {
            m.shiftUp();
        }
    }

    public void shiftDown() {
        for (var m: meshes) {
            m.shiftDown();
        }
    }

    public void shiftLeft() {
        for (var m: meshes) {
            m.shiftLeft();
        }
    }

    public void shiftRight() {
        for (var m: meshes) {
            m.shiftRight();
        }
    }

    public void setString(String fps) {
        this.fps = fps;
    }

    public void addCube() {
        meshes.add(new Cube());
    }

    public void addOctahedron() {
        meshes.add(new Octahedron());
    }

    public void addSphere() {
        meshes.add(new Sphere());
    }

    public void removeAllMeshes() {
        Mesh.numOfMeshes--;
        meshes.clear();
    }
}