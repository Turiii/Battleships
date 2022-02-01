package Model;


public class ShipPosition {
    private Point start;
    private Point end;
    private int length;

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int setLength(){
        if(start != end){
            int length1 = Math.abs(start.x - end.x);
            int length2 = Math.abs(start.y - end.y);
            return Math.max(length1, length2) + 1;
        }else
            return 1;
    }

    public int getLength() {
        return length;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public ShipPosition(Point start, Point end) {
        if (isPositionCorrect(start, end)) {
            this.start = start;
            this.end = end;
            this.length = setLength();
        }
    }

    public boolean isPointsValid(Point point_one, Point point_two) {
        return point_one.x == point_two.x || point_one.y == point_two.y;
    }

    public boolean isPositionCorrect(Point point_one, Point point_two) {
        return isPointsValid(point_one, point_two);
    }

    @Override
    public String toString() {
        return "ShipPosition{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
