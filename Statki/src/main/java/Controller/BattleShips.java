package Controller;

import Model.*;

import java.util.concurrent.TimeUnit;


public class BattleShips implements BattleShipMVC.Controller {

    private Player player1;
    private Player player2;

    @Override
    public void start() throws InterruptedException {
        player1 = new Player("Player One", new Ocean(), new Ocean());
        player1.ocean.start();
        player1.opponentOcean.start();
        System.out.println(player1.getName() + " deploying ships...");
        player1.deployShips();
        TimeUnit.SECONDS.sleep(5);
        clear();

        player2 = new Player("Player Two", new Ocean(), new Ocean());
        player2.ocean.start();
        player2.opponentOcean.start();
        System.out.println(player2.getName() + " deploying ships...");
        player2.deployShips();
        TimeUnit.SECONDS.sleep(5);
        clear();
    }

    @Override
    public void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    @Override
    public void turn(Player player, Player opponent) {
        System.out.println(player.getName() + " turn...");
        player.opponentOcean.print();
        System.out.println(player.getName() + " shooting...");
        player.shoot(player.requestInput(), opponent);
        player.opponentOcean.print();
        System.out.println("Left: " + opponent.getShips().size() + " ships to destroy.");
    }

    @Override
    public boolean gameOver() {
        return player1.getShips().size() == 0 || player2.getShips().size() == 0;
    }


    @Override
    public void battle() {
        while (!gameOver()) {
            turn(player1, player2);
            if (gameOver()) {
                System.out.println(player1.getName() + " won!");
                return;
            }
            turn(player2, player1);
            if (gameOver()) {
                System.out.println(player2.getName() + " won!");
                return;
            }
        }
        System.out.println("game over...");
    }
}
