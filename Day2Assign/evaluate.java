public class evaluate {
    public static void main(String[] args) {
        int i = 10, j=20, k=30;
        i=j++ + ++k; // j:20,  k:31
        System.out.println(i); // Ans = 51

        int x = 10, y=20, z=30;
        var result = x+(y*(z-y))/y;
        //          10+(20*(30-20))/20
        //          10+(20*(10))/20
        //          10+(200)/20
        //          10+10
        //   Ans:   20
        System.out.println(result);

        int a = 10, b=20, c=30;
        result = a + b * c - ++a / b % c + (b - c) * a;
        //      10 + 20*30 - ++10/20 % 30 + (20-30)*10
        //      10 + 600 - 11/20 % 30 + (-10)*10
        //      10 + 600 - 0 % 30 - 100
        //      10 + 600 - 0 - 100
        //Ans:   510
        System.out.println(result);
    }
}
