class NegativeSalaryException extends RuntimeException {

    public NegativeSalaryException(String message) {
        super(message);
    }
}

public class SalaryCheck {

    static void checkSalary(double salary) {
        if (salary < 0) {
            throw new NegativeSalaryException("Salary cannot be negative");
        }
        System.out.println("Valid Salary: " + salary);
    }

    public static void main(String[] args) {

        try {
            checkSalary(25000);
            checkSalary(-5000);
        } catch (NegativeSalaryException e) {
            System.out.println(e.getMessage());
        }
    }
}
