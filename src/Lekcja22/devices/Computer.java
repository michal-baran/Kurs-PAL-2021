package Lekcja22.devices;

import Lekcja22.control.*;

import java.util.Map;
import java.util.Scanner;

public class Computer {
    public static Scanner scanner = new Scanner(System.in);
    private Map<Integer, Command> commandMap = Map.of(
            1, new AddFish(),
            2, new AddPlant(),
            3, new ChangeWater(),
            4, new GetReport()
    );

    public static Computer create() {
        return new Computer();
    }

    public void powerOn() {
        while (true) {
            System.out.println("Select command:");
            for (Map.Entry<Integer, Command> command : commandMap.entrySet()) {
                System.out.println(command.getKey() + ". " + command.getValue());
            }
            try {
                commandMap.get(scanner.nextInt()).execute();
            } catch (NullPointerException e) {
                System.out.println("Incorrect command number\n");
            }
        }
    }
}
