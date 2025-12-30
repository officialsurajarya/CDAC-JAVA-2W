class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private double balance;

    static String bankName = "State Bank of India";

    BankAccount(int accNo, String name, double bal) {
        accountNumber = accNo;
        accountHolderName = name;
        balance = bal;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && balance - amount >= 1000) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Withdrawal failed. Maintain minimum balance ₹1000.");
        }
    }

    double getBalance() {
        return balance;
    }

    void displayAccountDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
        System.out.println("------------------------------");
    }
}

public class BankTest {
    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount(101, "Surya", 5000);
        BankAccount acc2 = new BankAccount(102, "Amit", 3000);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();

        acc1.deposit(2000);
        acc1.withdraw(1500);

        acc2.deposit(1000);
        acc2.withdraw(2500);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
    }
}
