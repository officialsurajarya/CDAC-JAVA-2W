// Parent class
class Parent {

    void showParent() {
        System.out.println("parent class");
    }
}

// Child class
class Child extends Parent {

    void showChild() {
        System.out.println("child class");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {

        Parent p = new Parent();
        p.showParent();

        Child c = new Child();
        c.showChild();

        c.showParent();
    }
}
