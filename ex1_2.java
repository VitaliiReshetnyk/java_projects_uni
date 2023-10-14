package ex1_2;
import java.util.Scanner;

/**
 * 3theme
 * exercise1_2
 * @author Vitalii Reshetnyk
 */public class ex1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        System.out.println("Enter integers one at a time. Enter 0 to finish.");

        while (true) {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        if (max == Integer.MIN_VALUE && min == Integer.MAX_VALUE) {
            System.out.println("You didn't enter any numbers.");
        } else {
            System.out.println("Largest number: " + max);
            System.out.println("Smallest number: " + min);
        }

        scanner.close();
    }
}
