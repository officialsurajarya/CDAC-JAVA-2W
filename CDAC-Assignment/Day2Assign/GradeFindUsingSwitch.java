public class GradeFindUsingSwitch {
    public static void main(String[] args) {
        char inp = 'B';
        switch (inp) {
            case 'A':
                System.out.println("Excelent");
                break;
            case 'B':
                System.out.println("Good");
                break;
            case 'C':
                System.out.println("Average");
                break;   
            case 'D':
                System.out.println("Poor");
                break;
            case 'E':
                System.out.println("Fail");
                break;   
            default:
                System.out.println("Invalid Grade");
                break;
        }
    }
}
