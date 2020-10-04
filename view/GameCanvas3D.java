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
    private String fps = "";
    private static final long serialVersionUID = 1L;
    private ArrayList<Mesh> meshes;
    private GamePanel3D gamePanel3D;
    private Graphics2D g2;
    
    private final int[] TRIANGLE_ICON_X = {740, 765, 790};
    private final int[] TRIANGLE_ICON_Y = {790, 740, 790};
    private final int HEIGHT = GamePanel3D.WINDOW_HEIGHT;
    private final int WIDTH = GamePanel3D.WINDOW_WIDTH;
    private final Color grid = new Color(30, 30, 30);

    public static Color squareIconColor;
    public static Color triangleIconColor;
    public static Color sphereIconColor;
    public static Color wireframeColor;
    public static Color solidColor;
    public static Color vertexOnlyColor;

    public GameCanvas3D(GamePanel3D gamePanel3D) {
        this.gamePanel3D = gamePanel3D;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
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

        // grid lines
        g2.setColor(grid);
        // vertical
        for (int i = 1; i < 16; i++) {
            g2.drawLine(WIDTH / 16 * i, 0, WIDTH / 16 * i, HEIGHT);
        }
        // horizontal
        for (int i = 1; i < 16; i++) {
            g2.drawLine(0, HEIGHT / 16 * i, WIDTH, HEIGHT / 16 * i);
        }
        // (0,0,0)
        g2.setColor(new Color(50, 10, 10));
        g2.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        g2.drawLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2);

        g2.setColor(Color.RED);
        g2.setFont(new Font("Courier", Font.PLAIN, 12));
        g2.drawString(fps, 10, 10);

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