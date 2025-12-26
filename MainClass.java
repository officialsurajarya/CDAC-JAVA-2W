class Vehicle {
    void startEngine() {
        System.out.println("Engine Started");
    }
}

class Car extends Vehicle {
    void openSunroof() {
        System.out.println("Sunroof Opened");
    }
}

class Bike extends Vehicle {
    void kickStart() {
        System.out.println("Bike Started");
    }
}

public class MainClass {
    void childDisplay() {
        System.out.println("Child display");
    }

    public static void main(String[] args) {
        Bike obj = new Bike();
        obj.startEngine();
        obj.kickStart();

        Car obj2 = new Car();
        obj2.startEngine();
        obj2.openSunroof();
    }
}