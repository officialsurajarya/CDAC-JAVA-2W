interface Greeting {
    default void sayHello() {
        System.out.println("Hello");
    }
}

class EnglishGreeting implements Greeting {
    public void sayHello() {
        System.out.println("Hello");
    }
}

public class GreetingDemo {
    public static void main(String[] args) {
        Greeting g = new EnglishGreeting();
        g.sayHello();
    }
}
