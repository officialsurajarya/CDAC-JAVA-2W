package Day3Code;

class Student2 {
    public int marks;

    public void setMarks(int m) {
        marks = m;
    }

    public int getMarks() {
        return marks;
    }
}

public class IncapsulationEx {
    public static void main(String[] args) {
        Student2 s = new Student2();
        s.marks = 10;
        s.setMarks(85);
        System.out.println("Marks: " + s.getMarks());
    }
}
