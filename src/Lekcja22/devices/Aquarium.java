package Lekcja22.devices;

import Lekcja22.creatures.Creature;
import Lekcja22.data.Data;

public class Aquarium {
    Computer computer = new Computer();

    public static Aquarium create() {
        return new Aquarium();
    }

    public void init() {
        computer.powerOn();
    }

    public void adjustPhLevel(double value) {
        if (Math.abs(value) < Data.phLevel && value != 0) {
            Data.phLevel += value;
        } else {
            System.out.println("Incorrect value for ph level adjustment");
        }
    }

    public void adjustWaterHardnessLevel(double value) {
        if (Math.abs(value) < Data.waterHardnessLevel && value != 0) {
            Data.waterHardnessLevel += value;
        } else {
            System.out.println("Incorrect value for water hardness adjustment");
        }
    }

    public void adjustToxicLevel(int value) {
        if (Math.abs(value) < Data.toxicLevel && value != 0) {
            Data.toxicLevel += value;
        } else {
            System.out.println("Incorrect value for toxic level adjustment");
        }
    }

    @Override
    public String toString() {
        return "Aquarium parameters: ph=" + Data.phLevel + ", hardness=" + Data.waterHardnessLevel + ", toxic=" + Data.toxicLevel;
    }

    public static void addFish() {
        Data.creaturesList.add(new Creature("Fish", true));
    }

    public static void addPlant() {
        Data.creaturesList.add(new Creature("Plant", false));
    }
}
