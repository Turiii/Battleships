package Controller;

import Model.Point;

public interface OceanInterface {
    void start();
    boolean isOccupied(Point point);
    void print();
}
