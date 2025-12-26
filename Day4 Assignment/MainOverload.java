class MainOverload {

    public static void main(String[] args) {
        System.out.println("Main method with String[] args");

        main(10);
        main(5.5);
    }

    public static void main(int a) {
        System.out.println("Overloaded main with int: " + a);
    }

    public static void main(double b) {
        System.out.println("Overloaded main with double: " + b);
    }
}
