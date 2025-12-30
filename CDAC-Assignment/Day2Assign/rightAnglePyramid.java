public class rightAnglePyramid {
    public static void main(String[] args) {

        int rows = 4;

        for (int i = 1; i <= rows; i++) {

            // print spaces
            for (int s = rows - i; s > 0; s--) {
                System.out.print("  ");
            }

            // print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}

