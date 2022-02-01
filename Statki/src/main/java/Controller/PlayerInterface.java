package Controller;

import Model.Point;
import Model.ShipPosition;
import Model.ShipType;

import java.util.List;

public interface PlayerInterface {
    void shoot(Point point, Player opponent);

    boolean canYouDeployShip(ShipType type, ShipPosition position);

    Ship deployShip(ShipPosition position, ShipType type);

    Point requestInput();

    void deployShips();
}
