class ExecutionOrder {

    static {
        System.out.println("1. Static Block Executed");
    }

    ExecutionOrder() {
        System.out.println("2. Constructor Executed");
    }

    static void staticMethod() {
        System.out.println("3. Static Method Executed");
    }

    public static void main(String[] args) {
        ExecutionOrder obj = new ExecutionOrder();
        ExecutionOrder.staticMethod();
    }
}
