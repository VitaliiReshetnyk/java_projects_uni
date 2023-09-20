package ex1_2;
import java.util.Scanner;

/**
 * exercise1_2
 * @author Vitalii Reshetnyk
 */public class ex1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        if (a.equals(b))
        {
            System.out.println("strings are equal");
        }
        else
        {
            System.out.println("strings are NOT equal");
        }

        scanner.close();
    }
}
