import java.util.Scanner;

public class GuessMyNumberGame {
    public static void main(String[] args) {
        int myNum = (int)(Math.random()*100);
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("--------------------------------\nPress Zero (0) for Exit The Game\nPlease enter your guessed number: ");
            int userInput = sc.nextInt(); 
            System.out.println();
            if (userInput == 0){
                System.out.println("Good Bye");
                break;
            }
            else if  (myNum == userInput) {
                System.out.println("Congratulations You Guessed Correct Number: "+ myNum);
                break;
            } else if (myNum < userInput) { 
                System.out.println("OOPS Wrong Ans.\nPlease Try again smaller than: "+ userInput);
            } else if (myNum > userInput){
                System.out.println("OOPS Wrong Ans.\nPlease Try again greater than: "+ userInput);
            }
        }
    }
}
