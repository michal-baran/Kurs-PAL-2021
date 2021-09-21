package Lekcja22.control;

public class ChangeWater implements Command {
    @Override
    public void execute() {
        System.out.println("Changing water in aquarium...\n");
    }

    @Override
    public String toString() {
        return "Change water";
    }
}
