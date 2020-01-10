import java.util.Scanner;

public class Player{
    public int[][] playerGrid;
    public char[][] opponentGrid;
    public int playerLives;



    public Player(int[][] playerGrid, char[][] opponentGrid, int playerLives) {
        this.playerGrid = playerGrid;
        this.opponentGrid = opponentGrid;
        this.playerLives = playerLives;
    }

    public int[][] getPlayerGrid() {
        return playerGrid;
    }

    public void setPlayerGrid(int[][] playerGrid) {
        this.playerGrid = playerGrid;
    }

    public char[][] getOpponentGrid() {
        return opponentGrid;
    }

    public void setOpponentGrid(char[][] opponentGrid) {
        this.opponentGrid = opponentGrid;
    }

    public int getPlayerLives() {
        return playerLives;
    }

    public void setPlayerLives(int playerLives) {
        this.playerLives = playerLives;
    }
}
