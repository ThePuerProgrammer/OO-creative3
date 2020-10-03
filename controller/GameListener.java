package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Mesh;
import view.GamePanel3D;
import view.GamePanel3D.GameState;

public class GameListener implements KeyListener, MouseListener {

    private GamePanel3D gamePanel3D;
    private boolean zAxisRotation = false;
    private boolean scalePerspective = false;


    public GameListener(GamePanel3D gamePanel3D) {
        this.gamePanel3D = gamePanel3D;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gamePanel3D.gameState == GameState.RUNNING) {
            switch (e.getKeyCode()) {
                // w 
                case 0x57: 
                    gamePanel3D.setShiftUp(true);
                    break;
                // a
                case 0x41:
                    gamePanel3D.setShiftLeft(true);
                    break;
                // s
                case 0x53:
                    gamePanel3D.setShiftDown(true);
                    break;
                // d
                case 0x44:
                    gamePanel3D.setShiftRight(true);
                    break;
                // 'c'
                case 0x43:
                    zAxisRotation = true;
                    break;
                case 0x56:
                    scalePerspective = true;
                    break;
                // left arrow key
                case 0x25:
                    if (!zAxisRotation) {
                        gamePanel3D.setRotateLeft(true);
                        gamePanel3D.setRotateRight(false);
                    } else {
                        gamePanel3D.setRotateCounterClockwise(true);
                        gamePanel3D.setRotateClockwise(false);
                    }
                    break;
                // up arrow key
                case 0x26:
                if (!scalePerspective) {
                    gamePanel3D.setRotateUp(true);
                    gamePanel3D.setRotateDown(false);
                } else {
                    Mesh.setScale(true);
                }
                    break;
                // right arrow key
                case 0x27:
                    if (!zAxisRotation) {
                        gamePanel3D.setRotateRight(true);
                        gamePanel3D.setRotateLeft(false);
                    } else {
                        gamePanel3D.setRotateClockwise(true);
                        gamePanel3D.setRotateCounterClockwise(false);
                    }
                    break;
                // down arrow key
                case 0x28:
                if (!scalePerspective) {
                    gamePanel3D.setRotateDown(true);
                    gamePanel3D.setRotateUp(false);
                } else {
                    Mesh.setScale(false);
                }
                    break;

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (gamePanel3D.gameState == GameState.RUNNING) {
            switch (e.getKeyCode()) {
                // w 
                case 0x57: 
                    gamePanel3D.setShiftUp(false);
                    break;
                // a
                case 0x41:
                    gamePanel3D.setShiftLeft(false);
                    break;
                // s
                case 0x53:
                    gamePanel3D.setShiftDown(false);
                    break;
                // d
                case 0x44:
                    gamePanel3D.setShiftRight(false);
                    break;
                // 'c'
                case 0x43:
                    zAxisRotation = false;
                    break;
                case 0x56:
                    scalePerspective = false;
                    break;
                // left arrow key
                case 0x25:
                    {
                        gamePanel3D.setRotateLeft(false);
                        gamePanel3D.setRotateCounterClockwise(false);
                    }
                    break;
                // up arrow key
                case 0x26:
                    gamePanel3D.setRotateUp(false);
                    break;
                // right arrow key
                case 0x27:
                    {
                        gamePanel3D.setRotateRight(false);
                        gamePanel3D.setRotateClockwise(false);
                    }
                    break;
                // down arrow key
                case 0x28:
                    gamePanel3D.setRotateDown(false);
                    break;

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if ((x >= 10 && x <= 60) && (y >= 740 && y <= 790)) {
            Mesh.setRenderState(1);
            Mesh.setFilled(false);
        } else if ((x >= 70 && x <= 120) && (y >= 740 && y <= 790)) {
            Mesh.setRenderState(1);
            Mesh.setFilled(true);
        } else if ((x >= 130 && x <= 180) && (y >= 740 && y <= 790)) {
            Mesh.setRenderState(0);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}