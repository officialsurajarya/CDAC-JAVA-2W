class Member {
    String name;
    int age;
    String address;
    double salary;
}

class Emp extends Member {
    String shift;
}

class Manager extends Member {
    String department;
}

public class MemberDemo {
    public static void main(String[] args) {

        Emp e = new Emp();
        e.name = "Ravi Kumar";
        e.age = 25;
        e.address = "Patna, Bihar";
        e.salary = 25000;
        e.shift = "Night";

        Manager m = new Manager();
        m.name = "Amit Singh";
        m.age = 35;
        m.address = "Delhi";
        m.salary = 60000;
        m.department = "IT";

        System.out.println("Employee Details:");
        System.out.println("Name: " + e.name);
        System.out.println("Age: " + e.age);
        System.out.println("Address: " + e.address);
        System.out.println("Salary: " + e.salary);
        System.out.println("Shift: " + e.shift);

        System.out.println();

        System.out.println("Manager Details:");
        System.out.println("Name: " + m.name);
        System.out.println("Age: " + m.age);
        System.out.println("Address: " + m.address);
        System.out.println("Salary: " + m.salary);
        System.out.println("Department: " + m.department);
    }
}
