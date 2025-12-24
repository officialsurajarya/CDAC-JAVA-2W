package Day3Code;

class Stdnt2 {
    int id;
    String name;

    Stdnt2(int id,String name) {
        this.id = id;
        this.name = name;
        // System.out.println("Hello");
    }
}


public class constructor {
    public static void main(String[] args) {
        Stdnt2 s2 = new Stdnt2(1,"Stdnt");
        System.out.println(s2.id+" "+s2.name);
    }
}
