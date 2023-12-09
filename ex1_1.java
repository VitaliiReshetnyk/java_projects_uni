package ex1_1;
/**
 * 5theme
 * exercise1_1
 * @author Vitalii Reshetnyk
 */
public class ex1_1 {
    public static void main(String[] args) {
        String text;

        if (args.length > 0) {
            text = String.join(" ", args);
        } else {
            text = "Example of the text. We count number of words.";
        }

        int wordCount = countWords(text);
        System.out.println("Number of words: " + wordCount);
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }
}
