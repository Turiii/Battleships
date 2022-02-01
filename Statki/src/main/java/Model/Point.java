package Model;

public class Point {
     int x;
     int y;

    public Point(int x, int y) {
        if(isValidPoint()){
            this.x = x;
            this.y = y;
        }
    }

    public boolean isValidPoint(){
        return (x >= 0 && x <= 10) && (y >= 0 && y <= 10);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
