import java.util.Scanner;

public class CheckVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter CitizenShip (Y/N): ");
        char citizenshipStatus = sc.next().charAt(0);

        if(age>=18) {
            if (citizenshipStatus == 'y' || citizenshipStatus =='Y') {
                System.out.println("Your Are Eligible to vote");
            }else {
                System.out.println("Not Eligible (not a citizen)");
            }
        }else {
            System.out.println("Not eligible (too young)");
        }
        sc.close();
    }
}
