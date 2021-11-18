package Lekcja25.Data;

import Lekcja25.Control.Game;
import Lekcja25.Control.Player;

import java.util.*;

public class Deck {
    private final List<Card> cards = new ArrayList<>(EnumSet.allOf(Card.class));

    public Deck shuffle() {
        System.out.println("Oryginalna kolejność: " + cards);
        Collections.shuffle(cards);
        System.out.println("Potasowana kolejność: " + cards);
        return this;
    }

    public void dealCards() {
        Player actPlayer = Game.players.get(0);
        for (Card card : cards) {
            System.out.println("Karta " + card + " dla gracza " + actPlayer.getName());
            actPlayer.addCard(card);
            actPlayer = Game.players.get(actPlayer.equals(Game.players.get(0)) ? 1 : 0);
        }
        System.out.println("Zakończono rozdawanie kart");
    }


}