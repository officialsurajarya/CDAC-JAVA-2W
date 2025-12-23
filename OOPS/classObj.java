class Pen {
    String color;
    String type;

    public void write() {
        System.out.println("Pen Color: "+ color + "\nType: " + type);
    }

    public void printe() {
        System.out.println(color);
        System.out.println(this.color);
    }
}

public class classObj {
    public static void main(String[] args) {
        Pen pen1 = new Pen();
        pen1.color = "Red";
        pen1.type = "Gel";
        // pen1.write();
        pen1.printe();
        
        Pen pen2 = new Pen();
        pen2.color = "Green";
        pen2.type = "Ballpoint";
        // pen2.write();
    }
}