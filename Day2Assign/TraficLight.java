import java.util.Scanner;

public class TraficLight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Color Name (red, yellow, green): ");
        String str = sc.nextLine().toLowerCase();

        if (str.equals("red")) {
            System.out.println("Stop");
        }
        else if(str.equals("yellow")) {
            System.out.println("Get Ready");
        }
        else if(str.equals("Green")) {
            System.out.println("Go");
        }
        else {
            System.out.println("Invalid Color");
        }
        sc.close();
    }
}
