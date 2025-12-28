public class Test {

    public static void main(String[] args) {

        // int marks[] = new int[5];

        // int[] arr = { 25, 20, 30, 46 };
        String strArr[] = { "Python", "Java", "C" };

        int len = strArr.length;
        System.out.println(len);

        for (String a : strArr) {
            System.out.print(a + ", ");
        }
        // for (int i = 0; i <= 3; i++) {
        // System.out.print(arr[i] + ", ");
        // }

    }
}