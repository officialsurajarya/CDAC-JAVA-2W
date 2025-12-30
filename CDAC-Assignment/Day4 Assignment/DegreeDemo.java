class Degree {
    void getDegree() {
        System.out.println("I got a degree");
    }
}

class Undergraduate extends Degree {
    @Override
    void getDegree() {
        System.out.println("Undergraduate");
    }
}

class Postgraduate extends Degree {
    @Override
    void getDegree() {
        System.out.println("Postgraduate");
    }
}

public class DegreeDemo {
    public static void main(String[] args) {

        Degree d = new Degree();
        d.getDegree();

        Undergraduate ug = new Undergraduate();
        ug.getDegree();

        Postgraduate pg = new Postgraduate();
        pg.getDegree();
    }
}
