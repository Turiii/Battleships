

import java.util.Scanner;

public class Battleship {
    public static int[][] playerOneGrid = new int[10][10];
    public static char[][] playerOneOpponentGrid = new char[10][10];
    public static int[][] playerTwoGrid = new int[10][10];
    public static char[][] playerTwoOpponentGrid = new char[10][10];
    public static Player player1 = new Player(playerOneGrid,playerOneOpponentGrid,0);
    public static Player player2 = new Player(playerTwoGrid,playerTwoOpponentGrid,0);


    public static void playerOneTurn(){
        System.out.println("Player1 turn...");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me X coordinate: ");
        int x = scanner.nextInt();
        System.out.println("Give me Y coordinate: ");
        int y = scanner.nextInt();
        if(player2.playerGrid[y][x] == 0){
            player2.playerGrid[y][x] = 1;
            System.out.println("Nice shot, you got him!");
            player2.playerLives--;
            player1.opponentGrid[y][x] = 'X';
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(player1.opponentGrid[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("You missed!");
            player1.opponentGrid[y][x] = '@';
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(player1.opponentGrid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void playerTwoTurn(){
        System.out.println("Player2 turn...");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me X coordinate: \n");
        int x = scanner.nextInt();
        System.out.println("Give me Y coordinate: \n");
        int y = scanner.nextInt();
        if(player1.playerGrid[y][x] == 0){
            player1.playerGrid[y][x] = 1;
            System.out.println("Nice shot, you got him!\n");
            player1.playerLives--;
            player2.opponentGrid[y][x] = 'X';
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(player2.opponentGrid[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("You missed!\n");
            player2.opponentGrid[y][x] = '@';
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(player2.opponentGrid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static boolean gameOver(){
        if(player1.playerLives == 0){
            System.out.println("Player2 won!");
            return true;
        }
        if(player2.playerLives == 0){
            System.out.println("Player1 won!");
            return true;
        }
        return false;
    }

    public static void deployPatrolBoat(int[][] grid, int x, int y){
        grid[y][x] = 0;
    }

    public static void deploySubmarine(int[][] grid, int x1, int y1, int x2, int y2){
        if(x1 != x2 && y1 != y2){
            return;
        }
        if(x1 - x2 > 1 || x2 - x1 > 1){
            return;
        }
        if(y1 - y2 > 1 || y2 - y1 > 1){
            return;
        }
        for (int i = y1; i <= y2 ; i++) {
            for (int j = x1; j <= x2 ; j++) {
                grid[i][j] = 0;
            }
        }
    }
    public static void deployBattleship(int[][] grid, int x1, int y1, int x2, int y2){
        if(x1 != x2 && y1 != y2){
            return;
        }
        if(x1 - x2 > 2 || x2 - x1 > 2){
            return;
        }
        if(y1 - y2 > 2 || y2 - y1 > 2){
            return;
        }
        for (int i = y1; i <= y2 ; i++) {
            for (int j = x1; j <= x2 ; j++) {
                grid[i][j] = 0;
            }
        }
    }
    public static void deployCarrier(int[][] grid, int x1, int y1, int x2, int y2){
        if(x1 != x2 && y1 != y2){
            return;
        }
        if(x1 - x2 > 3 || x2 - x1 > 3){
            return;
        }
        if(y1 - y2 > 3 || y2 - y1 > 3){
            return;
        }
        for (int i = y1; i <= y2 ; i++) {
            for (int j = x1; j <= x2 ; j++) {
                grid[i][j] = 0;
            }
        }
    }
    public static void deployPlayerShips(int[][] playerGrid){
        Scanner scanner = new Scanner(System.in);
        int x1;
        int y1;
        int x2;
        int y2;
        System.out.println("Please give me coordinates for your first Patrol Boat.\n");
        System.out.println("Enter the vertical coordinate:");
        x1 = scanner.nextInt();
        System.out.println("Enter the horizontal coordinate:");
        y1 = scanner.nextInt();
        deployPatrolBoat(playerGrid,x1,y1);

        System.out.println("Please give me coordinates for your second Patrol Boat.\n");
        System.out.println("Enter the vertical coordinate:");
        x1 = scanner.nextInt();
        System.out.println("Enter the horizontal coordinate:");
        y1 = scanner.nextInt();
        deployPatrolBoat(playerGrid,x1,y1);

        System.out.println("Please give me coordinates for your Submarine.");
        System.out.println("Enter the vertical coordinate of beakhead:");
        x1 = scanner.nextInt();
        System.out.println("Enter the horizontal coordinate of beakhead:");
        y1 = scanner.nextInt();
        System.out.println("Enter the vertical coordinate of stern:");
        x2 = scanner.nextInt();
        System.out.println("Enter the horizontal coordinate of stern:");
        y2 = scanner.nextInt();
        deploySubmarine(playerGrid,x1,y1,x2,y2);

        System.out.println("Please give me coordinates for your Battleship.");
        System.out.println("Enter the vertical coordinate of beakhead:");
        x1 = scanner.nextInt();
        System.out.println("Enter the horizontal coordinate of beakhead:");
        y1 = scanner.nextInt();
        System.out.println("Enter the vertical coordinate of stern:");
        x2 = scanner.nextInt();
        System.out.println("Enter the horizontal coordinate of stern:");
        y2 = scanner.nextInt();
        deployBattleship(playerGrid,x1,y1,x2,y2);

        System.out.println("Please give me coordinates for your Carrier.");
        System.out.println("Enter the vertical coordinate of beakhead:");
        x1 = scanner.nextInt();
        System.out.println("Enter the horizontal coordinate of beakhead:");
        y1 = scanner.nextInt();
        System.out.println("Enter the vertical coordinate of stern:");
        x2 = scanner.nextInt();
        System.out.println("Enter the horizontal coordinate of stern:");
        y2 = scanner.nextInt();
        deployCarrier(playerGrid,x1,y1,x2,y2);
    }


    public static void main(String[] args) {
        System.out.println("Battleship 1.0\n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerOneGrid[i][j] = 1;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerOneOpponentGrid[i][j] = '?';
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerTwoGrid[i][j] = 1;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                playerTwoOpponentGrid[i][j] = '?';
            }
        }
        deployPlayerShips(player1.playerGrid);
        player1.playerLives = 11;
        System.out.println("This is player1 grid with ships.");
        for (int i = 0; i < player1.playerGrid.length; i++) {
            for (int j = 0; j < player1.playerGrid.length; j++) {
                System.out.print(player1.playerGrid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n\n");

        deployPlayerShips(player2.playerGrid);
        player2.playerLives = 11;
        System.out.println("This is player2 grid with ships.");
        for (int i = 0; i < player2.playerGrid.length; i++) {
            for (int j = 0; j < player2.playerGrid.length; j++) {
                System.out.print(player2.playerGrid[i][j] + " ");
            }
            System.out.println();
        }

        do{
           playerOneTurn();
           playerTwoTurn();
        }while(!gameOver());


    }



}
