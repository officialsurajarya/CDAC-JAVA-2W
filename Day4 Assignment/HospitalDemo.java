class Hospital {

    int getNumberOfPatients() {
        return 0;
    }
}

class Fortis extends Hospital {

    int getNumberOfPatients() {
        return 120;
    }
}

class Narayana extends Hospital {

    int getNumberOfPatients() {
        return 200;
    }
}

class Apolo extends Hospital {

    int getNumberOfPatients() {
        return 150;
    }
}

public class HospitalDemo {
    public static void main(String[] args) {

        Hospital h = new Fortis();
        System.out.println("Fortis Hospital Patients: " + h.getNumberOfPatients());

        Hospital h1 = new Narayana();
        System.out.println("Narayana Hospital Patients: " + h1.getNumberOfPatients());

        Hospital h2 = new Apolo();
        System.out.println("Apolo Hospital Patients: " + h2.getNumberOfPatients());
    }
}
