class Shape {
    void showShape() {
        System.out.println("shape");
    }
}

class Rectangle extends Shape {
    void showRectangle() {
        System.out.println("rectangular shape");
    }
}

class Circle extends Shape {
    void showCircle() {
        System.out.println("circular shape");
    }
}

class Square extends Rectangle {
    void showSquare() {
        System.out.println("Square is a rectangle");
    }
}

public class ShapeDemo {
    public static void main(String[] args) {

        Square sq = new Square();

        sq.showShape();

        sq.showRectangle();

        sq.showSquare();
    }
}
