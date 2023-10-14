package ex2_1;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 3theme
 * exercise2_1
 * @author Vitalii Reshetnyk
 */public class ex2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows (m): ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of columns (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];

        System.out.println("Enter the matrix elements:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Sort each row of the matrix
        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
        }

        System.out.println("Sorted Matrix:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}