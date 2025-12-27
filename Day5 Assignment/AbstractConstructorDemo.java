abstract class Shape {
    String name;

    Shape(String name) {
        this.name = name;
        System.out.println("Shape constructor called");
    }

    abstract void draw();
}

class Circle extends Shape {

    Circle(String name) {
        super(name);
        System.out.println("Circle constructor called");
    }

    void draw() {
        System.out.println("Drawing " + name);
    }
}

public class AbstractConstructorDemo {
    public static void main(String[] args) {
        Shape s = new Circle("Circle");
        s.draw();
    }
}
