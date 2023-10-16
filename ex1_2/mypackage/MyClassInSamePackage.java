package mypackage;

public class MyClassInSamePackage {
    public static void main(String[] args) {
        MyParent parent = new MyParent();
        parent.protectedMethod(); // Accessing protected method within the same package
    }
}
