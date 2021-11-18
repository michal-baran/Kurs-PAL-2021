package Lekcja25.Control;

import Lekcja25.Data.Deck;

import java.util.ArrayList;
import java.util.List;

//    Zaimplementuj grę karcianą w wojnę.
//    Dla uproszczenie nie będziemy rozróżniać kolorów w talii.
//    Mamy 13 kart danego koloru. Każda ma swoją wartość 2-9, J, Q, K, A
//    W grze ma uczestniczyć dwóch symulowanych graczy.
//    Każdy z graczy otrzymuje równą ilość kart, są one losowe.
//    Należy pokazać jak przebiega każda walka, wskazać zwycięzce

public class Game {
    private final int MAX_WINNINGS = 3;
    public static final List<Player> players = new ArrayList<>();

    public static Deck deck = new Deck();

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        Stage stage = Stage.INIT;
        while (stage != null) {
            try {
                stage.init();
                stage = stage.nextState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}