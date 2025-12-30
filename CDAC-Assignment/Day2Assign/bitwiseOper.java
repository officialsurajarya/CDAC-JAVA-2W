public class bitwiseOper {
    public static void main(String[] args) {   
        int a = 2;
        int b = 3;
        System.out.println(a&b); 
        // 2 = 0010
        // 3 = 0011
        // a&b 0010 Ans: 2      if both true then ans will be true
        
        System.out.println(a|b);
        // 2 = 0010
        // 3 = 0011
        // a|b 0011 Ans: 3      if one true then ans will true

        System.out.println(a^b);
        // 2 = 0010
        // 3 = 0011
        // a^b 0001 Ans: 1      id both same then false 

        System.out.println(~a);
        // 2 = 0010
        // -3  1101
    }
}
