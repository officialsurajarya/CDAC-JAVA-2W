class Bank {
    int getBalance() {
        return 0;
    }
}

class BankA extends Bank {
    @Override
    int getBalance() {
        return 10000;
    }
}

class BankB extends Bank {
    @Override
    int getBalance() {
        return 15000;
    }
}

class BankC extends Bank {
    @Override
    int getBalance() {
        return 20000;
    }
}

public class BankDemo {
    public static void main(String[] args) {

        Bank a = new BankA();
        System.out.println("Balance in Bank A: Rs " + a.getBalance());

        Bank b = new BankB();
        System.out.println("Balance in Bank B: Rs " + b.getBalance());

        Bank c = new BankC();
        System.out.println("Balance in Bank C: Rs " + c.getBalance());
    }
}
