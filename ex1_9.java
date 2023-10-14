package ex1_9;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 3theme
 * exercise1_9
 * @author Vitalii Reshetnyk
 */public class ex1_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int[] arr = {123, 456, 789, 321, 543, 987};
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int largestUniqueDigitNumber = findLargestUniqueDigitNumber(arr);

        if (largestUniqueDigitNumber != -1) {
            System.out.println("The largest number with unique digits is: " + largestUniqueDigitNumber);
        } else {
            System.out.println("No number with unique digits found in the array.");
        }
        scanner.close();
    }

    public static int findLargestUniqueDigitNumber(int[] arr) {
        int result = -1;

        for (int num : arr) {
            if (hasUniqueDigits(num) && (num > result)) {
                result = num;
            }
        }

        return result;
    }

    public static boolean hasUniqueDigits(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (num > 0) {
            int digit = num % 10;
            if (digits.contains(digit)) {
                return false;
            }
            digits.add(digit);
            num /= 10;
        }
        return true;
    }
}
