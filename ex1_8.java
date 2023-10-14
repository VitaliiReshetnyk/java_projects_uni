package ex1_8;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * 3theme
 * exercise1_8
 * @author Vitalii Reshetnyk
 */public class ex1_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        ArrayList<Integer> increasingNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (areDigitsIncreasing(number)) {
                increasingNumbers.add(number);
            }
        }

        if (increasingNumbers.isEmpty()) {
            System.out.println("No numbers with increasing digits found.");
        } else {
            System.out.println("Numbers with increasing digits:");
            for (int num : increasingNumbers) {
                System.out.println(num);
            }
        }

        scanner.close();
    }

    public static boolean areDigitsIncreasing(int number) {
        String numStr = String.valueOf(number);
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) >= numStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
