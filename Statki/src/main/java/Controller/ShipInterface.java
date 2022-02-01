package Controller;

import Model.Point;
import Model.ShipPosition;
import Model.ShipType;

import java.util.List;

public interface ShipInterface {
    void buildShip(ShipPosition shipPosition);

    boolean isDestroyed();

    boolean isHit(Point point);
}
