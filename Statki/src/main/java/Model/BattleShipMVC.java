package Model;

import Controller.*;

public interface BattleShipMVC {
    interface Controller{
        void start() throws InterruptedException;
        void battle();
        void turn(Player player, Player opponent);
        boolean gameOver();
        void clear();
    }
    interface View{

    }
}
