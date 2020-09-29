import javax.swing.JFrame;

import view.GamePanel3D;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel3D gamePanel3D = new GamePanel3D(window);
        gamePanel3D.init();
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}