package KółkoKrzyżyk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Board {
    private int size;
    private List<List<Field>> fields = new ArrayList<>();

    public Board() {
        System.out.print("Podaj rozmiar planszy: ");
        size = Game.sc.nextInt();
        Game.sc.nextLine();
        for (int i = 0; i < size; i++) {
            ArrayList<Field> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Field());
            }
            fields.add(row);
        }
        this.show();
    }

    public int getSize() {
        return size;
    }

    public char getFieldSymbol(int x, int y) {
        return fields.get(y - 1).get(x - 1).getSymbol();
    }

    public void setFieldSymbol(int x, int y, char symbol) {
        Field field = fields.get(y - 1).get(x - 1);
        if (field.isOccupied()) {
            throw new FieldOccupied();
        } else {
            field.setSymbol(symbol);
        }
    }

    static Board create() {
        try {
            return new Board();
        } catch (InputMismatchException e) {
            Game.sc.nextLine();
            System.out.println("Podaj liczbę!");
            return Board.create();
        }
    }

    public void reset() {
        for (List<Field> list : fields) {
            for (Field f : list) {
                f.clear();
            }
        }
    }

    public void show() {
        for (int i = 0; i < fields.size(); i++) {
            List<Field> row = fields.get(i);
            for (int j = 0; j < row.size(); j++) {
                System.out.print("[" + row.get(j).getSymbol() + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isMoveAvailable() {
        int freeFields = 0;
        for (List<Field> row : fields) {
            for (Field f : row) {
                if (!f.isOccupied()) {
                    freeFields++;
                }
            }
        }
        if (freeFields > 0) {
            return true;
        } else {
            System.out.println("Brak wolnych pól!");
            return false;
        }
    }
}