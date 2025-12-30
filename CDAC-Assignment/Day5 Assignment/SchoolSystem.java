class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    String role() {
        return "General Person";
    }
}

class Student extends Person {
    Student(String name) {
        super(name);
    }

    @Override
    String role() {
        return "Student";
    }
}

class Teacher extends Person {
    Teacher(String name) {
        super(name);
    }

    @Override
    String role() {
        return "Teacher";
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Person p1 = new Student("Aman");
        Person p2 = new Teacher("Rita");

        System.out.println(p1.name + " is a " + p1.role());
        System.out.println(p2.name + " is a " + p2.role());
    }
}
