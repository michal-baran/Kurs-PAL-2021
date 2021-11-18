package Lekcja25.Control;

import java.util.Collections;
import java.util.List;

public enum Stage {
    INIT {
        @Override
        public void init() {
            List<Player> list = Game.players;
            Collections.addAll(list, new Player("Barnaba"), new Player("Dominik"));
            System.out.println("Rozpoczęcie gry");
        }

        @Override
        public Stage nextState() {
            return DEAL;
        }
    },

    DEAL {
        @Override
        public void init() {
            System.out.println("Rozdanie kart");
            Game.deck.shuffle().dealCards();
        }

        @Override
        public Stage nextState() {
            return TAKE_TURN;
        }
    },

    TAKE_TURN {
        @Override
        public void init() throws InterruptedException {
            System.out.println("Wykonanie ruchu");
            Thread.sleep(1000);
        }

        @Override
        public Stage nextState() {
            return CHECK_WINNER;
        }
    },

    CHECK_WINNER {
        @Override
        public void init() throws InterruptedException {
            System.out.println("Sprawdzenie wyniku");
            Thread.sleep(1000);
        }

        @Override
        public Stage nextState() {
            return TAKE_TURN;
        }
    };

    public abstract void init() throws InterruptedException;

    public abstract Stage nextState();
}