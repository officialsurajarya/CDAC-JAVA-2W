public class Book {
    int bookId;
    String title;
    double price;

    Book() {
        bookId = 0;
        title = "Not Assigned";
        price = 0.0;
    }

    Book(int id, String t, double p) {
        bookId = id;
        title = t;
        price = p;
    }

    void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("----------------------");
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {

        Book b1 = new Book();
        b1.display();

        Book b2 = new Book(101, "Java Programming", 499.50);
        b2.display();
    }
}
