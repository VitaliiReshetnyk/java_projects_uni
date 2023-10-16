package anotherpackage; // This is a different package

import mypackage.MyParent;

public class MyClassInDifferentPackage {
    public static void main(String[] args) {
        MyParent parent = new MyParent();
        parent.protectedMethod(); // Compilation error: The method protectedMethod() from the type MyParent is not visible
    }
}
