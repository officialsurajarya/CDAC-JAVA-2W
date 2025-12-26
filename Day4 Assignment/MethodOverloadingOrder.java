class MethodOverloadingOrder {

    void show(int a, char b) {
        System.out.println("Integer: " + a);
        System.out.println("Character: " + b);
    }

    void show(char b, int a) {
        System.out.println("Character: " + b);
        System.out.println("Integer: " + a);
    }

    public static void main(String[] args) {
        MethodOverloadingOrder obj = new MethodOverloadingOrder();
        obj.show(10, 'A');
        obj.show('B', 20);
    }
}
