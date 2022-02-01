import Controller.*;
import View.GameFrame;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        GameFrame frame = new GameFrame();

        BattleShips game = new BattleShips();
        game.start();
        while (!game.gameOver()){
            game.battle();
        }
    }
}
