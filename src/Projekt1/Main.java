package Projekt1;

//        Napisz prostą grę w kółko krzyżyk
//
//        Wymagania:
//        1. Gra ma być na dwóch graczy
//        2. Rozmiar planszy ma być konfigurowany na starcie gry
//        3. Gracze mają mieć możliwość wprowadzenia swojego imienia
//        4. Gracz wygrywa, gdy ma 3 swoje symbole obok siebie w dowolnej konfiguracji - pion, poziom, skos
//        5. Gracze mają wprowadzać wybór swojego pola jeden po drugim
//        6. Program ma znajdować moment w którym jeden z graczy zwycięża
//        7. Gra ma mieć 3 rundy
//        8. Zaczynający turę gracz ma się zmieniać co rozgrywkę
//        9. Można zakończyć grę w dowolnym momencie po wpisaniu słowa quit
//        10. Gra ma informować jakie dane powinny być wprowadzone.

//        Możliwe rozszerzenia:
//          1. Gra na wielu graczy
//          2. Możliwość grania dowolnym symbolem
//          3. Możliwość zdefiniowania ile symboli obok siebie daje zwycięstwo

//          Jak projektować klasę?
//          Jak zapisywać interakcje między klasami?

public class Main {
    public static void main(String[] args) {
        Game.create()
                .init()
                .play();
    }
}