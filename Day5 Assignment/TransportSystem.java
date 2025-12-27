class Vehicle {
    String getFuelType() {
        return "Unknown";
    }
}

class Car extends Vehicle {
    @Override
    String getFuelType() {
        return "Petrol";
    }
}

class Bike extends Vehicle {
    @Override
    String getFuelType() {
        return "Diesel";
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();

        System.out.println("Car fuel type: " + v1.getFuelType());
        System.out.println("Bike fuel type: " + v2.getFuelType());
    }
}
