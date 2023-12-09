package ex1_4;

import java.util.Scanner;
/**
 * 5theme
 * exercise1_4
 * @author Vitalii Reshetnyk
 */
public class ex1_4 {
    static public void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine()
                .replace("an", "")
                .replace("a", "");
        System.out.println(str);
    }
}
