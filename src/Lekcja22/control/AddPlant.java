package Lekcja22.control;

import Lekcja22.devices.Aquarium;

public class AddPlant extends AddCreature{
    @Override
    public void execute() {
        System.out.println("Adding plant...");
        Aquarium.addPlant();
    }

    @Override
    public String toString() {
        return "Add plant";
    }
}
