package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameListener;

public class GamePanel3D implements Runnable {

    public enum GameState {
        STANDBY, RUNNING
    }

    public GameState gameState;

    JFrame window = new JFrame();
    private GameCanvas3D gameCanvas3D;
    private GameListener gameListener;
    public static final int WINDOW_HEIGHT = 800;
    public static final int WINDOW_WIDTH  = 800;
    private final int FPS = 60;
    private final int TIME = 1000 / FPS;
    private Thread thread;

    private boolean rotateUp = false;
    private boolean rotateDown = false;
    private boolean rotateLeft = false;
    private boolean rotateRight = false;
    private boolean rotateClockwise = false;
    private boolean rotateCounterClockwise = false;
    private boolean shiftUp = false;
    private boolean shiftDown = false;
    private boolean shiftLeft = false;
    private boolean shiftRight = false;

    public GamePanel3D(JFrame window) {
        this.window = window;
        window.setTitle("Generic 3D Physics Demo");
        window.setFocusable(true);
        window.requestFocus();
        gameState = GameState.STANDBY;
    }

    public void init() {
        Container contentPane = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        contentPane.add(BorderLayout.CENTER, panel);
        gameCanvas3D = new GameCanvas3D(this);
        panel.add(BorderLayout.CENTER, gameCanvas3D);
        gameListener = new GameListener(this);
        window.addKeyListener(gameListener);
        gameCanvas3D.addMouseListener(gameListener);
        start();
    }

    public void start() {
        gameState = GameState.RUNNING;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (gameState == GameState.RUNNING) {
            // To aim for consistent FPS
            long nano = System.nanoTime();
            tick();
            gameCanvas3D.repaint();
            long updated = System.nanoTime() - nano;
            long buffer = TIME - updated / 1_000_000;
            if (buffer <= 0) {
                buffer = 5;
            }
            try {
                Thread.sleep(buffer);
            } catch (Exception e) {
                System.out.println("Caught Exception - Thread.sleep(buffer)");
                System.exit(1);
            }
        }
    }

    public void tick() {

        if (rotateUp) {
            gameCanvas3D.rUp();
        } else if (rotateDown) {
            gameCanvas3D.rDown();
        }

        if (rotateLeft) {
            gameCanvas3D.rLeft();
        } else if (rotateRight) {
            gameCanvas3D.rRight();
        }

        if (rotateClockwise) {
            gameCanvas3D.rClockwise();
        } else if (rotateCounterClockwise) {
            gameCanvas3D.rCounterClockwise();
        }

        if (shiftUp) {
            gameCanvas3D.shiftUp();
        } else if (shiftDown) {
            gameCanvas3D.shiftDown();
        }

        if (shiftLeft) {
            gameCanvas3D.shiftLeft();
        } else if (shiftRight) {
            gameCanvas3D.shiftRight();
        }

    }

    public void setRotateUp(boolean rotateUp) {
        this.rotateUp = rotateUp;
    }

    public void setRotateDown(boolean rotateDown) {
        this.rotateDown = rotateDown;
    }

    public void setRotateLeft(boolean rotateLeft) {
        this.rotateLeft = rotateLeft;
    }

    public void setRotateRight(boolean rotateRight) {
        this.rotateRight = rotateRight;
    }

    public void setRotateClockwise(boolean rotateClockwise) {
        this.rotateClockwise = rotateClockwise;
    }

    public void setRotateCounterClockwise(boolean rotateCounterClockwise) {
        this.rotateCounterClockwise = rotateCounterClockwise;
    }

    public void setShiftDown(boolean shiftDown) {
        this.shiftDown = shiftDown;
    }

    public void setShiftUp(boolean shiftUp) {
        this.shiftUp = shiftUp;
    }

    public void setShiftLeft(boolean shiftLeft) {
        this.shiftLeft = shiftLeft;
    }

    public void setShiftRight(boolean shiftRight) {
        this.shiftRight = shiftRight;
    }

    public void addCubeToCanvas() {
        gameCanvas3D.addCube();
    }

    public void addOctahedronToCanvas() {
        gameCanvas3D.addOctahedron();
    }

    public void addSphereToCanvas() {
        gameCanvas3D.addSphere();
    }

    public void clearCanvas() {
        gameCanvas3D.removeAllMeshes();
    }
}
