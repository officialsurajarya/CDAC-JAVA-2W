import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    char grade;

    public Student(int id, String name, char grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}

public class StudentSerialization {

    public static void main(String[] args) {

        Student s1 = new Student(101, "Surya", 'A');
        String filename = "student.ser";

        try (FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(s1);
            System.out.println("Student object serialized to " + filename);

        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            Student s2 = (Student) ois.readObject();
            System.out.println("\nDeserialized Student details:");
            System.out.println("ID: " + s2.id);
            System.out.println("Name: " + s2.name);
            System.out.println("Grade: " + s2.grade);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
