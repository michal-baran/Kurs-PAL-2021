package Projekt1;

public class FieldOccupied extends RuntimeException {
    public FieldOccupied() {
        super("Pole zajęte!");
    }
}
