package Projekt1;

import java.util.*;

public class Game implements Initialisable, Playable {
    public static Scanner sc = new Scanner(System.in);
    private Player actPlayer;
    private int symbolsToWin = 3;
    private int actMove[] = new int[2];
    private int round = 1;
    private int state = 0;
    private int noOfPlayers = 2;
    private List<Player> players = new ArrayList<>();
    private Board board;

    static Initialisable create() {
        return new Game();
    }

    @Override
    public Playable init() {
        board = Board.create();
        players = Player.createPlayers(noOfPlayers);
        return this;
    }

    @Override
    public void play() {
        System.out.println("Gra się rozpoczyna. Mamy planszę o rozmiarze " + board.getSize() + "x" + board.getSize() + " i " + noOfPlayers + " graczy.");
        start(state = 0);
    }

    public void start(int state) {
        while (true) {
            switch (state) {
                case 0: {
                    board.reset();
                    System.out.println("\nRunda " + round);
                    actPlayer = players.get((round - 1) % 2);
                    state = 1;
                    break;
                }
                case 1: {
                    takeTurn(actPlayer);
                    state = 2;
                    break;
                }

                case 2: {
                    if (isWinner()) {
                        state = 4;
                        break;
                    }
                    switchPlayer();
                    state = 3;
                    break;
                }

                case 3: {
                    if (board.isMoveAvailable()) {
                        state = 1;
                    } else {
                        state = 4;
                    }
                    break;
                }

                case 4: {
                    System.out.println("Rundę wygrywa " + actPlayer.getName() + "!");
                    System.out.println("Wyniki:");
                    for (Player player : players) {
                        System.out.println(player.getName() + ": " + player.getTotalWins());
                    }
                    round++;
                    if (round <= 3) {
                        state = 0;
                    } else {
                        state = 5;
                    }
                    break;
                }

                case 5: {
                    Collections.sort(players);
                    System.out.println("Koniec gry, wygrał " + players.get(0).getName() + "!");
                    return;
                }
            }
        }
    }

    private void takeTurn(Player player) throws InputMismatchException {
        System.out.print(player.getName() + ", podaj współrzędne ruchu (x y): ");
        actMove[0] = sc.nextInt();  // kolumna x
        actMove[1] = sc.nextInt();  // wiersz y
        try {
            board.setFieldSymbol(actMove[0], actMove[1], actPlayer.getSymbol());
            board.show();
        } catch (FieldOccupied e) {
            System.out.println(e.getMessage());
            takeTurn(player);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Współrzędne nieprawidłowe!");
            takeTurn(player);
        }
    }

    private void switchPlayer() {
        int index = actPlayer.getNumber();
        if (index < players.size()) {
            actPlayer = players.get(index);
        } else {
            actPlayer = players.get(0);
        }
    }

    public boolean isWinner() {
        int size = board.getSize();
        char symbol = actPlayer.getSymbol();
        int x1 = actMove[0] <= symbolsToWin ? 1 : ((actMove[0] - symbolsToWin) + 1); //x1
        int y1 = actMove[1] <= symbolsToWin ? 1 : actMove[1] - symbolsToWin + 1; //y1
        int x2 = actMove[0] + symbolsToWin > size ? size : actMove[0] + symbolsToWin - 1;    //x2
        int y2 = actMove[1] + symbolsToWin > size ? size : actMove[1] + symbolsToWin - 1;    //y2


        //sprawdzenie kolumn
        for (int j = 0; j < symbolsToWin; j++) {
            for (int i = 0; i < symbolsToWin; i++) {
                if (y1 + j + i > y2 || board.getFieldSymbol(actMove[0], (y1 + j + i)) != symbol) {
                    break;
                }
            }
        }

        //sprawdzenie wierszy
        for (int j = 0; j < symbolsToWin; j++) {
            for (int i = 0; i < symbolsToWin; i++) {
                if (y1 + j + i > y2 || board.getFieldSymbol(actMove[0], (y1 + j + i)) != symbol) {
                    break;
                }
                if (i == symbolsToWin - 1) {
                    actPlayer.addWin();
                    return true;
                }
            }
        }

        //sprawdzenie przekątnych "opadających"
        for (int j = 0; j < symbolsToWin; j++) {
            for (int i = 0; i < symbolsToWin; i++) {
                if (x1 + j + i > x2 || board.getFieldSymbol((x1 + j + i), actMove[1]) != symbol) {
                    break;
                }
                if (i == symbolsToWin - 1) {
                    actPlayer.addWin();
                    return true;
                }
            }
        }

        //sprawdzenie przekątnych "rosnących"
        for (int j = 0; j < symbolsToWin; j++) {
            for (int i = 0; i < symbolsToWin; i++) {
                if ((x1 + j + i > x2) || (y2 - j - i < y1) || board.getFieldSymbol((x1 + j + i), (y2 - j - i)) != symbol) {
                    break;
                }
                if (i == symbolsToWin - 1) {
                    actPlayer.addWin();
                    return true;
                }
            }
        }
        return false;
    }
}