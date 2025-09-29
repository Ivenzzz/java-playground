package design_patterns;

public class FactoryMethod2 {
    public static void main(String[] args) {
        WaterState state1 = WaterFactory.getWaterState(-5);
        System.out.println(state1.describe());
        // Output: I am ice, solid and cold!

        WaterState state2 = WaterFactory.getWaterState(25);
        System.out.println(state2.describe());
        // Output: I am liquid water, perfect for drinking.

        WaterState state3 = WaterFactory.getWaterState(120);
        System.out.println(state3.describe());
        // Output: I am steam, hot and gaseous!
    }
}

interface WaterState {
    String describe();
}

class Ice implements WaterState {

    @Override
    public String describe() {
        return "I am ice, solid and cold!";
    }
}

class LiquidWater implements WaterState {
    @Override
    public String describe() {
        return "I am liquid water, perfect for drinking.";
    }
}

class Steam implements WaterState {
    @Override
    public String describe() {
        return "I am steam, hot and gaseous!";
    }
}

class WaterFactory {

    public static WaterState getWaterState(double temperatureCelsius) {
        if (temperatureCelsius <= 0) {
            return new Ice();
        } else if (temperatureCelsius < 100) {
            return new LiquidWater();
        } else {
            return new Steam();
        }
    }
}
