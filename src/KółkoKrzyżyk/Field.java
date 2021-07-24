package KółkoKrzyżyk;

public class Field {
    private boolean occupied = false;
    private char symbol = ' ';

    public boolean isOccupied() {
        return occupied;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
        this.occupied = true;
    }

    public void clear() {
        this.symbol = ' ';
        this.occupied = false;
    }
}