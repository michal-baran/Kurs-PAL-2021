package Lekcja25.Data;

import java.util.LinkedList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new LinkedList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
