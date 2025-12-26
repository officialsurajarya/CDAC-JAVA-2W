class MethodOverloadingType {

    void add(int a, int b) {
        System.out.println("Sum of integers: " + (a + b));
    }

    void add(double a, double b) {
        System.out.println("Sum of doubles: " + (a + b));
    }

    void add(float a, float b) {
        System.out.println("Sum of floats: " + (a + b));
    }

    void add(String a, String b) {
        System.out.println("String concatenation: " + a + b);
    }

    public static void main(String[] args) {
        MethodOverloadingType obj = new MethodOverloadingType();

        obj.add(10, 20);
        obj.add(10.5, 20.5);
        obj.add(5.5f, 4.5f);
        obj.add("Hello ", "Java");
    }
}
