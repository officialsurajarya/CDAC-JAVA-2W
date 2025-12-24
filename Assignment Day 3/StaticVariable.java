class Student {
    int id; // instance variable
    static String collegeName = "C-DAC Patna"; // static variable

    Student(int id) {
        this.id = id;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("College Name: " + collegeName);
        System.out.println("-------------------");
    }
}

public class StaticVariable {
    public static void main(String[] args) {

        Student s1 = new Student(101);
        Student s2 = new Student(102);
        Student s3 = new Student(103);

        s1.display();
        s2.display();
        s3.display();
    }
}
