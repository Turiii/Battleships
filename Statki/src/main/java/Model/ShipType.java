package Model;

public enum ShipType {
    PATROLBOAT("Patrolboat", 1),
    SUBMARINE("Submarine", 2),
    BATTLESHIP("Batlleship", 3),
    CARRIER("Carrier", 4);

    private final String name;
    private final int size;

    ShipType(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
