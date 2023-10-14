package ex1_4;
import java.util.Scanner;
/**
 * 3theme
 * exercise1_4
 * @author Vitalii Reshetnyk
 */public class ex1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sequence of integers separated by spaces:");
        String input = scanner.nextLine();
        scanner.close();

        String[] numbers = input.split(" ");
        int currentNumber = Integer.parseInt(numbers[0]);
        int maxNumber = currentNumber;
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);

            if (num == currentNumber) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxNumber = currentNumber;
                }
                currentNumber = num;
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxNumber = currentNumber;
        }

        System.out.println("The number that occurs in a row the largest number of times is: " + maxNumber);
        System.out.println("It occurs " + maxCount + " times in a row.");
    }
}
