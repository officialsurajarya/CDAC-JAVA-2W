abstract class Vehicle {
    abstract void fuelEfficiency();

    void startEngine() {
        System.out.println("Engine started");
    }
}

class Car extends Vehicle {
    void fuelEfficiency() {
        System.out.println("Car mileage is 15 km/l");
    }
}

class Bike extends Vehicle {
    void fuelEfficiency() {
        System.out.println("Bike mileage is 45 km/l");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v;

        v = new Car();
        v.startEngine();
        v.fuelEfficiency();

        v = new Bike();
        v.startEngine();
        v.fuelEfficiency();
    }
}
