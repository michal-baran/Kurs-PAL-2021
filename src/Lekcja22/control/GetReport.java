package Lekcja22.control;

import Lekcja22.data.Data;

public class GetReport implements Command {
    @Override
    public void execute() {
        System.out.print("Aquarium parameters: ph=" + Data.phLevel + ", hardness=" + Data.waterHardnessLevel + ", toxic=" + Data.toxicLevel +
                "\nHabitants: \n");
    }

    @Override
    public String toString() {
        return "Generate report";
    }
}
