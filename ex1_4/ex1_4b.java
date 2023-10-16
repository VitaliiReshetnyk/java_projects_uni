package ex1_4;

public class ex1_4b {
    public static void main(String[] args) {
        ex1_4a firstObject = new ex1_4a();

        System.out.println("Original Protected Data: " + firstObject.protectedData);

        // We can access and modify the protected data from the same package
        firstObject.manipulateProtectedData(100);

        System.out.println("Updated Protected Data: " + firstObject.protectedData);
    }
}