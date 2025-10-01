package design_patterns;

public class FactoryMethod3 {
    public static void main(String[] args) {
        SedanFactory sedanFactory = new SedanFactory();
        Sedan sedan = (Sedan) sedanFactory.createCar();
        System.out.println(sedan.drive());

        SUVFactory suvFactory = new SUVFactory();
        SUV suv = (SUV) suvFactory.createCar();
        System.out.println(suv.drive());
    }
}

interface Car {
    String drive();
}

class Sedan implements Car {
    @Override
    public String drive() {
        return "Driving a comfortable sedan.";
    }
}

class SUV implements Car {
    @Override
    public String drive() {
        return "Driving a spacious SUV.";
    }
}

abstract class CarFactory {
    public abstract Car createCar();
}

class SedanFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new Sedan();
    }
}   

class SUVFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new SUV();
    }
}




