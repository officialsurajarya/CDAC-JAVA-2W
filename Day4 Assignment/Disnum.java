class DisNum {

    void disData(int a) {
        System.out.println("Integer value: " + a);
    }

    void disData(float b) {
        System.out.println("Float value: " + b);
    }

    void disData(double c) {
        System.out.println("Double value: " + c);
    }

    void disData(long d) {
        System.out.println("Long value: " + d);
    }

    public static void main(String[] args) {
        DisNum obj = new DisNum();

        obj.disData(10);
        obj.disData(25.5f);
        obj.disData(99.99);
        obj.disData(123456789L);
    }
}
