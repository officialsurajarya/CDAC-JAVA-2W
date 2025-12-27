class Student {
    String name;
    int rollNo;
    char grade;

    Student(String name) {
        this.name = name;
        System.out.println("Name: " + name);
    }

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        System.out.println("Name: " + name + ", Roll No: " + rollNo);
    }

    Student(String name, int rollNo, char grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
        System.out.println("Name: " + name + ", Roll No: " + rollNo + ", Grade: " + grade);
    }
}

public class SchoolRegistration {
    public static void main(String[] args) {
        Student s1 = new Student("Aman");
        Student s2 = new Student("Ravi", 101);
        Student s3 = new Student("Neha", 102, 'A');
    }
}
