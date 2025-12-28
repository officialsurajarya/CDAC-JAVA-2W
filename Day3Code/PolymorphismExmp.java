package Day3Code;

class Stdnt1 {
    int x;

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

public class PolymorphismExmp {
    public static void main(String[] args) {
        Stdnt1 c = new Stdnt1();
        c.x = 10;
        System.err.println(c.x);
        System.out.println(c.add(4, 5, 6));
        System.out.println(c.add(4.1, 5.5));
    }
}
