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
import model.Triangle;

public class GameCanvas3D extends JPanel {
    private String fps = "hi";
    private String vertices = "";
    private static final long serialVersionUID = 1L;
    private ArrayList<Mesh> meshes;
    private GamePanel3D gamePanel3D;
    private Graphics2D g2;

    public GameCanvas3D(GamePanel3D gamePanel3D) {
        this.gamePanel3D = gamePanel3D;
        setPreferredSize(new Dimension(GamePanel3D.WINDOW_WIDTH, GamePanel3D.WINDOW_HEIGHT));
        setBackground(new Color(0 , 0, 30));
        meshes = new ArrayList<>();
        meshes.add(new Cube());
    } 

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;

        g2.setColor(Color.RED);
        g2.setFont(new Font("Courier", Font.PLAIN, 12));
        g2.drawString(fps, 10, 10);
        g2.drawString(vertices, 10, 24);

        g2.drawRect(10, 740, 50, 50);
        g2.fillRect(70, 740, 50, 50);
        g2.fillOval(130, 740, 5, 5);
        g2.fillOval(150, 740, 5, 5);
        g2.fillOval(175, 740, 5, 5);
        g2.fillOval(175, 760, 5, 5);
        g2.fillOval(175, 785, 5, 5);
        g2.fillOval(150, 785, 5, 5);
        g2.fillOval(130, 785, 5, 5);
        g2.fillOval(130, 760, 5, 5);

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

    public void setString(String fps) {
        this.fps = fps;
    }

    // public void addCube() {
    //     Mesh cube = new Cube();
    //     meshes.add(cube);
    // }

}