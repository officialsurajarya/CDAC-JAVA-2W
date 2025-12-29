public class temp {
    public static void main(String[] args) {
        int age = 19;
        char citizen = 'y';
        if (age>=18) {
            if (citizen == 'y'){
                System.out.println("You can Vote");
            }else {
                System.out.println("Your are not a citizen");
            }
        }else {
            System.out.println("You are child");
        }
    }
}
