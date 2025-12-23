public class switchEx {
    public static void main(String[] args) {
        char a= 'a';
        switch (a) {
            case 'a':
                System.out.println("Excelent");
                break;
            case 'b':
                System.out.println("Good");
                break;
            case 'c':
                System.out.println("Average");
                break;   
            case 'd':
                System.out.println("Poor");
                break;   
            default:
                System.out.println("Invalid Grade");
                break;
        }
    }
}
