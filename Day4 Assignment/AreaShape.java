class AreaShape {

    void area(int side) {
        int result = side * side;
        System.out.println("Area of Square: " + result);
    }

    void area(int length, int breadth) {
        int result = length * breadth;
        System.out.println("Area of Rectangle: " + result);
    }

    public static void main(String[] args) {
        AreaShape obj = new AreaShape();

        obj.area(5);
        obj.area(10, 4);
    }
}
