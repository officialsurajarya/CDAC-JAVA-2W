class Shape {
    void display() {
        System.out.println("Shape");
    }
}

class Square extends Shape {
    void area() {
        System.out.println("Area");
    }
}

public class singleInheritance {
    public static void main(String[] args) {

        Shape obj1 = new Shape();
        obj1.display();
        // obj2.area();

        Square obj2 = new Square();
        obj2.display();
        obj2.area();
    }
}