class MethodOverloading {

    void add(int a, int b) {
        System.out.println("Sum of two numbers: " + (a + b));
    }

    void add(int a, int b, int c) {
        System.out.println("Sum of three numbers: " + (a + b + c));
    }

    void add(int a, int b, int c, int d) {
        System.out.println("Sum of four numbers: " + (a + b + c + d));
    }

    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();

        obj.add(10, 20);
        obj.add(5, 10, 15);
        obj.add(2, 4, 6, 8);
    }
}
