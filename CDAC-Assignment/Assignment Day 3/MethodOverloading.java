class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {

        Calculator c = new Calculator();

        System.out.println("Two integers: " + c.add(10, 20));
        System.out.println("Three integers: " + c.add(10, 20, 30));
        System.out.println("Two doubles: " + c.add(5.5, 4.5));
    }
}
