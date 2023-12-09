package ex1_3;
import java.util.Scanner;
/**
 * 5theme
 * exercise1_3
 * @author Vitalii Reshetnyk
 */
public class ex1_3 {
    static public void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().replace("small", "very large");
        System.out.println(str);
    }
}
