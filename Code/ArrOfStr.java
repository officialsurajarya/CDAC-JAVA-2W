
public class ArrOfStr {

    void display() {
        String[] arr = { "Geeks", "for", "Geeks" };

        for (String s : arr) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        ArrOfStr obj = new ArrOfStr();
        obj.display();
    }
}
