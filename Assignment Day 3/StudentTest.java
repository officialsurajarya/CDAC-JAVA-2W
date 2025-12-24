class Student {

    private int rollNo;
    private String name;
    private int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;

        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks! Setting marks to 0.");
            this.marks = 0;
        }
    }

    String calculateGrade() {
        if (marks >= 75)
            return "A";
        else if (marks >= 60)
            return "B";
        else if (marks >= 40)
            return "C";
        else
            return "Fail";
    }

    void displayResult() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
        System.out.println("---------------------------");
    }
}

public class StudentTest {
    public static void main(String[] args) {

        Student s1 = new Student(1, "Surya", 85);
        Student s2 = new Student(2, "Amit", 62);
        Student s3 = new Student(3, "Rahul", 35);

        s1.displayResult();
        s2.displayResult();
        s3.displayResult();
    }
}
