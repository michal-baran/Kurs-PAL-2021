package KółkoKrzyżyk;

import java.util.ArrayList;

public class Player implements Comparable {
    private int number;
    private String name;
    private char symbol;
    private int totalWins = 0;

    public Player(String name, char symbol, int number) {
        this.name = name;
        this.symbol = symbol;
        this.number = number;
    }

    public static ArrayList<Player> createPlayers(int noOfPlayers) {
        ArrayList<Player> result = new ArrayList<>();
        for (int i = 1; i <= noOfPlayers; i++) {
            System.out.print("Podaj imie gracza #" + i + ": ");
            String name = Game.sc.nextLine();
            System.out.print("Podaj symbol gracza #" + i + ": ");
            char symbol = Game.sc.nextLine().charAt(0);
            result.add(new Player(name, symbol, i));
        }
        return result;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public int getNumber() {
        return this.number;
    }

    public void addWin() {
        this.totalWins++;
    }

    public int getTotalWins() {
        return totalWins;
    }

    @Override
    public int compareTo(Object o) {
        Player player = (Player) o;
        return Integer.compare(player.totalWins,this.getTotalWins());
    }
}
