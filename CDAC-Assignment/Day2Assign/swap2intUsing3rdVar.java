public class swap2intUsing3rdVar {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int temp;
        System.out.println("Before Swaping \na: "+a+"\nb: "+b);

        // swap
        temp = a;
        a = b;
        b = temp;

        System.out.println("After Swaping \na: "+a+"\nb: "+b);
    }
}
