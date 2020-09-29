package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.GamePanel3D;
import view.GamePanel3D.GameState;

public class GameListener implements KeyListener {

    private GamePanel3D gamePanel3D;
    private boolean xy = false;

    public GameListener(GamePanel3D gamePanel3D) {
        this.gamePanel3D = gamePanel3D;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gamePanel3D.gameState == GameState.RUNNING) {
            switch (e.getKeyCode()) {
                // 'c'
                case 0x43: xy = true;
                                break;
                // left arrow key
                case 0x25:  if (!xy) {
                                gamePanel3D.setRotateLeft(true);
                                gamePanel3D.setRotateRight(false);
                            } else {
                                gamePanel3D.setRotateCounterClockwise(true);
                                gamePanel3D.setRotateClockwise(false);
                            }
                           break;
                // up arrow key
                case 0x26: gamePanel3D.setRotateUp(true);
                           gamePanel3D.setRotateDown(false);
                           break;
                // right arrow key
                case 0x27:  if (!xy) {
                                gamePanel3D.setRotateRight(true);
                                gamePanel3D.setRotateLeft(false);
                            }  else {
                                gamePanel3D.setRotateClockwise(true);
                                gamePanel3D.setRotateCounterClockwise(false);
                            }
                           break;
                // down arrow key
                case 0x28: gamePanel3D.setRotateDown(true);
                           gamePanel3D.setRotateUp(false);
                           break;
                
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (gamePanel3D.gameState == GameState.RUNNING) {
            switch (e.getKeyCode()) {
                // 'c'
                case 0x43: xy = false;
                                break;
                // left arrow key
                case 0x25:  if (!xy) {
                                gamePanel3D.setRotateLeft(false);
                            } else {
                                gamePanel3D.setRotateCounterClockwise(false);
                            }
                           break;
                // up arrow key
                case 0x26: gamePanel3D.setRotateUp(false);
                           break;
                // right arrow key
                case 0x27:  if (!xy) {
                                gamePanel3D.setRotateRight(false);
                            }  else {
                                gamePanel3D.setRotateClockwise(false);
                            }
                           break;
                // down arrow key
                case 0x28: gamePanel3D.setRotateDown(false);
                           break;
                
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}