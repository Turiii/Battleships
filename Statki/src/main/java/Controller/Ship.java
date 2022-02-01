package Controller;

import Model.Point;
import Model.ShipPosition;
import Model.ShipType;

import java.util.ArrayList;
import java.util.List;

public class Ship implements ShipInterface {
    private ShipType shipType;
    private List<Point> elements;
    private ShipPosition position;

    public ShipPosition getPosition() {
        return position;
    }

    public void setPosition(ShipPosition position) {
        this.position = position;
    }

    Ship(ShipType type, ShipPosition position) {
        this.shipType = type;
        this.position = position;
        buildShip(position);
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public List<Point> getElements() {
        return elements;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setElements(List<Point> elements) {
        this.elements = elements;
    }

    @Override
    public void buildShip(ShipPosition shipPosition) {
        Point start = shipPosition.getStart();
        Point end = shipPosition.getEnd();
        List<Point> elementsToBuild = new ArrayList<>();

        for (int i = start.getX(); i <= end.getX(); i++) {
            for (int j = start.getY(); j <= end.getY(); j++) {
                elementsToBuild.add(new Point(i, j));
            }
        }
        setElements(elementsToBuild);
    }


    @Override
    public boolean isDestroyed() {
        return elements.isEmpty();
    }

    @Override
    public boolean isHit(Point point) {
        for (Point element :
                elements) {
            if (element.getX() == point.getX() && element.getY() == point.getY()) {
                elements.remove(element);
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Ship{" +
                "shipType=" + shipType +
                ", elements=" + elements +
                ", position=" + position +
                '}';
    }
}
