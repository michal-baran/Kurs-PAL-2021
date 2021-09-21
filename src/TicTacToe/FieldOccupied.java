package TicTacToe;

public class FieldOccupied extends RuntimeException {
    public FieldOccupied() {
        super("Pole zajęte!");
    }
}
