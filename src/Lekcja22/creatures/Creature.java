package Lekcja22.creatures;

public class Creature {
    private final String name;
    private final double requiredPh;
    private final double requredWaterHardness;
    private final boolean isFish;

    public Creature(String name, boolean isFish) {
        this.name = name;
        this.isFish = isFish;
        this.requiredPh = 4.5;
        this.requredWaterHardness = 15.0;
    }

    public Creature(String name, double requiredPh, double requiredWaterHardness, boolean isFish) {
        this.name = name;
        if (requiredPh > 0.0 && requiredPh <= 9.0) {
            this.requiredPh = requiredPh;
        } else {
            this.requiredPh = 4.5;
        }
        if (requiredWaterHardness > 0.0 && requiredWaterHardness <= 30.0) {
            this.requredWaterHardness = requiredWaterHardness;
        } else {
            this.requredWaterHardness = 15.0;
        }
        this.isFish = isFish;
    }
}
