class PrintData {

    void display(int n, char c) {
        System.out.println("Integer: " + n);
        System.out.println("Character: " + c);
    }

    void display(char c, int n) {
        System.out.println("Character: " + c);
        System.out.println("Integer: " + n);
    }

    public static void main(String[] args) {
        PrintData obj = new PrintData();

        obj.display(10, 'A');
        obj.display('B', 20);
    }
}
