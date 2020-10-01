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
    private final int fps = 60;
    private final int time = 1000 / fps;
    private Thread thread;

    private boolean rotateUp = false;
    private boolean rotateDown = false;
    private boolean rotateLeft = false;
    private boolean rotateRight = false;
    private boolean rotateClockwise = false;
    private boolean rotateCounterClockwise = false;

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
            long buffer = time - updated / 1_000_000;
            gameCanvas3D.setString("buffer: " + buffer + ", nano: " + nano + ", updated: " + updated);
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
}
