package ex2_10;

import java.util.regex.*;

/**
 * 5theme
 * exercise2_10
 * @author Vitalii Reshetnyk
 */

public class ex2_10 {

    public static void main(String[] args) {
        String inputString = "This is a sample string with some fragments.";

        String regex = "sample.*fragments";

        boolean result = searchFragment(inputString, regex);

        if (result) {
            System.out.println("Fragment found in the string.");
        } else {
            System.out.println("Fragment not found in the string.");
        }
    }

    public static boolean searchFragment(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }
}
