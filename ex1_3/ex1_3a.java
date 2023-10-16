package ex1_3;

public class ex1_3a {
    public int publicField = 10;
    private int privateField = 20;
    protected int protectedField = 30;
    int packageAccessField = 40; // Default access (package access)

    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }

    void packageAccessMethod() {
        System.out.println("This is a package (default) access method.");
    }
}
