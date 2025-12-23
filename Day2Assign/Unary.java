public class Unary {
    public static void main(String[] args) {
        int x = 5;
        
        ++x; //firstly increment then print
        System.out.println(x); //6 Ans

        int y=5;
        System.out.println(y++); //print then increment Ans:5
        System.out.println(y); // 6

        int i = 5;
        --i; //decrement then use
        System.out.println(i); //Ans 4

        int j = 5;
        System.out.println(j--); //print then decrement Ans:5
        System.out.println(j); //4
    }    
}
