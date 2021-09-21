package Lekcja22.control;

import Lekcja22.devices.Aquarium;

public class AddFish extends AddCreature{
    @Override
    public void execute() {
        System.out.println("Adding fish...");
        Aquarium.addFish();
    }

    @Override
    public String toString() {
        return "Add fish";
    }
}
