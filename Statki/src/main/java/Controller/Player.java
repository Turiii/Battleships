package Controller;

import Model.Point;
import Model.ShipPosition;
import Model.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements PlayerInterface {
    private String name;
    Ocean ocean;
    Ocean opponentOcean;
    private List<Ship> ships = new ArrayList<>();

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public Player(String name, Ocean ocean, Ocean opponentOcean) {
        this.name = name;
        this.ocean = ocean;
        this.opponentOcean = opponentOcean;
    }

    boolean canYouDeployShip(ShipPosition position) {
        Point start = position.getStart();
        Point end = position.getEnd();

        int newStartY = Math.max(start.getY() - 1, 0);

        int newEndY = Math.min(end.getY() + 1, 9);

        int newStartX = Math.max(start.getX() - 1, 0);

        int newEndX = Math.min(end.getX() + 1, 9);

        for (int i = newStartY; i <= newEndY; i++) {
            for (int j = newStartX; j <= newEndX; j++) {
                if (ocean.isOccupied(new Point(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean canYouDeployShip(ShipType type, ShipPosition position) {
        return type.getSize() == position.getLength();
    }

    @Override
    public Ship deployShip(ShipPosition position, ShipType type) {
        Ship ship = new Ship(type, position);
        Point start = position.getStart();
        Point end = position.getEnd();

        if (canYouDeployShip(type, position)) {
            ship.setPosition(position);
            ship.setShipType(type);
            ship.buildShip(position);

            //graficznie na konsoli
            for (int i = start.getY(); i <= end.getY(); i++) {
                for (int j = start.getX(); j <= end.getX(); j++) {
                    ocean.getOcean()[i][j] = 'O';
                }
            }
            for (int i = end.getY(); i <= start.getY(); i++) {
                for (int j = end.getX(); j <= start.getX(); j++) {
                    ocean.getOcean()[i][j] = 'O';
                }
            }
            //

            System.out.println("Ship deployed.");
            return ship;
        }else{
            System.out.println("Wrong position of ship, try again...");
            return deployShip(new ShipPosition(requestInput(), requestInput()), type);
        }
    }

    @Override
    public Point requestInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("X: ");
        int x = scanner.nextInt();
        System.out.println("Y: ");
        int y = scanner.nextInt();

        if ((x > 0 && x < 10) && (y > 0 && y < 10)) {
            return new Point(x - 1, y - 1);
        } else {
            System.out.println("Incorrect input, try again...");
            return requestInput();
        }
    }

    @Override
    public void deployShips() {
        ocean.print();

        System.out.println("deploying Patrolboat...");
        Point point = requestInput();
        Ship patrolboat = deployShip(new ShipPosition(point, point), ShipType.PATROLBOAT);
        ships.add(patrolboat);
        ocean.print();


        System.out.println("deploying Submarine...");
        Ship submarine = deployShip(new ShipPosition(requestInput(), requestInput()), ShipType.SUBMARINE);
        ships.add(submarine);
        ocean.print();


        /*System.out.println("deploying Battleship...");
        Ship battleship = deployShip(new ShipPosition(requestInput(), requestInput()));
        ships.add(battleship);
        ocean.print();


        System.out.println("deploying Carrier...");
        Ship carrier = deployShip(new ShipPosition(requestInput(), requestInput()));
        ships.add(carrier);
        ocean.print();*/
    }


    public String getName() {
        return name;
    }

    @Override
    public void shoot(Point point, Player opponent) {
        for (Ship ship :
                opponent.ships) {
            if (ship.isHit(point)) {
                System.out.println("You got him!");
                if (ship.isDestroyed()) {
                    System.out.println("You destroyed enemy " + ship.getShipType().getName());
                    opponent.ships.remove(ship);
                }
                opponentOcean.getOcean()[point.getY()][point.getX()] = '@';
                opponent.ocean.getOcean()[point.getY()][point.getX()] = '@';
                return;
            }
        }
        System.out.println("You missed!");
        opponentOcean.getOcean()[point.getY()][point.getX()] = '*';
    }
}

