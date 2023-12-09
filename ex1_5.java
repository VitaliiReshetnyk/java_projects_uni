package ex1_5;

import java.util.Scanner;
/**
 * 5theme
 * exercise1_5
 * @author Vitalii Reshetnyk
 */
public class ex1_5 {
    static public void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine()
                .replace("small", "very small")
                .replace("large", "very large");
        System.out.println(str);
    }
}
