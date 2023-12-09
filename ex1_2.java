package ex1_2;
/**
 * 5theme
 * exercise1_2
 * @author Vitalii Reshetnyk
 */
public class ex1_2 {
    public static void main(String[] args) {
        String text;

        if (args.length > 0) {
            text = String.join(" ", args);
        } else {
            text = "Example of text to be reversed";
        }

        String reversedText = reverseText(text);
        System.out.println("Reversed text: " + reversedText);
    }

    private static String reverseText(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
