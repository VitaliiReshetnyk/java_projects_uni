package ex1_1;

/**
 * 3theme
 * exercise1_1
 * @author Vitalii Reshetnyk
 */public class ex1_1 {
    public static void main(String[] args) {
        String[] stringArray = {"Hello", "World", "Java", "Array"};
        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i]);
            if (i < stringArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("Element at index " + i + ": " + stringArray[i]);
        }
    }
}
