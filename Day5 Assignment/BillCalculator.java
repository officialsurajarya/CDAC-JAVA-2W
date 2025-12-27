class ElectricityBill {

    double calculateBill(double units) {
        return units * 5;
    }

    double calculateBill(double units, double fixedCharge) {
        return (units * 5) + fixedCharge;
    }

    double calculateBill(double units, double fixedCharge, double tax) {
        return (units * 5) + fixedCharge + tax;
    }
}

public class BillCalculator {
    public static void main(String[] args) {
        ElectricityBill bill = new ElectricityBill();

        System.out.println("Bill (units only): " + bill.calculateBill(100));
        System.out.println("Bill (units + fixed charge): " + bill.calculateBill(100, 50));
        System.out.println("Bill (units + fixed charge + tax): " + bill.calculateBill(100, 50, 20));
    }
}
