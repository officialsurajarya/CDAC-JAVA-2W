class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double cash) {
        balance += cash;
        System.out.println("Deposited cash: " + cash + ", New balance: " + balance);
    }

    void deposit(double amount, String chequeNumber) {
        balance += amount;
        System.out.println("Deposited cheque " + chequeNumber + ": " + amount + ", New balance: " + balance);
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(101, 5000);

        acc.deposit(1000);
        acc.deposit(2000, "CH12345");
    }
}
