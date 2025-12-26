class Hospital {

    int getNumberOfPatients() {
        return 0;
    }
}

class Fortis extends Hospital {

    @Override
    int getNumberOfPatients() {
        return 120;
    }
}

class Narayana extends Hospital {

    @Override
    int getNumberOfPatients() {
        return 200;
    }
}

class Apolo extends Hospital {

    @Override
    int getNumberOfPatients() {
        return 150;
    }
}

public class HospitalDemo {
    public static void main(String[] args) {

        Hospital h;

        h = new Fortis();
        System.out.println("Fortis Hospital Patients: " + h.getNumberOfPatients());

        h = new Narayana();
        System.out.println("Narayana Hospital Patients: " + h.getNumberOfPatients());

        h = new Apolo();
        System.out.println("Apolo Hospital Patients: " + h.getNumberOfPatients());
    }
}
