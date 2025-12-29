interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class AllInOneDevice implements Printer, Scanner {
    public void print() {
        System.out.println("Printing document");
    }

    public void scan() {
        System.out.println("Scanning document");
    }
}

public class DeviceDemo {
    public static void main(String[] args) {
        AllInOneDevice d = new AllInOneDevice();
        d.print();
        d.scan();
    }
}
