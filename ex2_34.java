package ex2_34;

//not found such exercise in a book, this is a 2_11
/**
 * 5theme
 * exercise2_11
 * @author Vitalii Reshetnyk
 */

public class ex2_34 {

    public static void main(String[] args) {
        String input = "aaabbbbccddddeeee";
        String result = deleteLongestConsecutiveSequence(input);

        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result);
    }

    public static String deleteLongestConsecutiveSequence(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char currentChar = input.charAt(0);
        int currentCount = 1;

        char maxChar = currentChar;
        int maxCount = currentCount;

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < input.length(); i++) {
            char nextChar = input.charAt(i);

            if (nextChar == currentChar) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxChar = currentChar;
                }

                currentChar = nextChar;
                currentCount = 1;
            }
        }


        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxChar = currentChar;
        }

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current != maxChar) {
                result.append(current);
            } else {
                i += maxCount - 1;
            }
        }

        return result.toString();
    }
}