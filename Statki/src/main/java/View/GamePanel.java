package View;

import Controller.BattleShips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    BattleShips battleShips = new BattleShips();

    static final int SCREEN_WIDTH = 500;
    static final int SCREEN_HEIGHT = 500;
    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT_SIZE;
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    GamePanel() throws InterruptedException {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLUE);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyListener());
        battleShips.start();
    }

    public void startGame(){

    }

    public void paintComponent(Graphics graphics){

    }

    public void draw(Graphics graphics){

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
