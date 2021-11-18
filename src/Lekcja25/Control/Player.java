package Lekcja25.Control;

import Lekcja25.Data.Card;
import Lekcja25.Data.Hand;

public class Player {
    private final String name;
    private Hand hand;
    private int wins;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void addWin() {
        wins++;
    }
}