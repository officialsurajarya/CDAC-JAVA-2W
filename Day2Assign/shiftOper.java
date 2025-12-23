public class shiftOper {
    public static void main(String[] args) {
        int a = 5;
        
        // Right Shift
        System.out.println(a>>1);
        // 5 = 0101
        // 2 = 0010     each bit moves one position to the right.

        // Left Shift
        System.out.println(a<<1);
        //5 = 0101
        //10  1010      each bit moves one position to the left.
    }
}
