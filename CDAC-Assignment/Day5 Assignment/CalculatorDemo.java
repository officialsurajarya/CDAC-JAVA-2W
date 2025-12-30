interface Calculator {
    int add(int a, int b);

    int subtract(int a, int b);
}

class SimpleCalculator implements Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {
        SimpleCalculator c = new SimpleCalculator();
        System.out.println(c.add(10, 5));
        System.out.println(c.subtract(10, 5));
    }
}
