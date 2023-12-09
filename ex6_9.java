package ex6_9;

import java.util.Stack;

/**
 * я заплутався в підручнику, тому зробив це завдання
 * 6theme
 * exercise7_1_15
 * @author Vitalii Reshetnyk
 */

public class ex6_9 {

    public static void main(String[] args) {
        String input = "({[a*b] + }c)";

        if (checkBrackets(input)) {
            System.out.println("The brackets are placed correctly.");
        } else {
            System.out.println("The brackets are not placed correctly.");
        }
    }

    public static boolean checkBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else if (isClosingBracket(ch)) {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpeningBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isClosingBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }
}