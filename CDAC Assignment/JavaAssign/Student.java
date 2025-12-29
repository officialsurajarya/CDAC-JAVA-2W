public class Student {
    // instance variable 
    int roll;
    String name;

    // method to display
    void display() {
        System.out.println("Name = "+ name);
        System.out.println("Roll = "+ roll);
    }
    
    // main method
    public static void main(String[] args) {

        // create my first objct
        Student s1 = new Student();
        s1.roll = 1;
        s1.name = "Suraj";
        s1.display();

        System.out.println("-------------------------------");

        // create second object
        Student s2 = new Student();
        s1.roll = 4;
        s2.name = "Hello";
        s2.display();
    }
    
}