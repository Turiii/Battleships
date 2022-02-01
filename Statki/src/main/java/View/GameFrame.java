package View;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() throws InterruptedException {
        this.add(new GamePanel());
        this.setTitle("Battleships");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
