abstract class Shape {
    abstract void calculateArea();
}

class Circle extends Shape {
    double radius = 5;

    void calculateArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + area);
    }
}

class Rectangle extends Shape {
    double length = 10;
    double breadth = 4;

    void calculateArea() {
        double area = length * breadth;
        System.out.println("Area of Rectangle = " + area);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape s;

        s = new Circle();
        s.calculateArea();

        s = new Rectangle();
        s.calculateArea();
    }
}
