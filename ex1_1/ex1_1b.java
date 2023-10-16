import ex1_1a.ex1_1a;

public class ex1_1b {
    public static void main(String[] args) {
        ex1_1a myInstance = new ex1_1a("Hello from outside the package");

        myInstance.displayMessage();
    }
}