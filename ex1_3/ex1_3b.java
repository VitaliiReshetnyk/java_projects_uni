package ex1_3;

public class ex1_3b {
    public static void main(String[] args) {
        ex1_3a testObject = new ex1_3a();

        // Accessing public members is allowed
        System.out.println("Public field: " + testObject.publicField);
        testObject.publicMethod();

        // Attempting to access private members results in a compilation error
        // System.out.println("Private field: " + testObject.privateField); // Compilation error
        // testObject.privateMethod(); // Compilation error

        // Accessing protected and package (default) members is allowed within the same package
        System.out.println("Protected field: " + testObject.protectedField);
        testObject.protectedMethod();
        System.out.println("Package access field: " + testObject.packageAccessField);
        testObject.packageAccessMethod();
    }
}
