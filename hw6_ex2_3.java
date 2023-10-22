package ex2_3;

import java.util.Scanner;

/**
 * 3theme hw6
 * exercise2_3
 * @author Vitalii Reshetnyk
 */public class ex2_3 {
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
        scanner.close();
        printMatrix(matrix);
        findAndPrintLongestIncreasingSequence(matrix);





    }
    private static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    private static void findAndPrintLongestIncreasingSequence(int[][] matrix) {
        int longestSequenceLength = 0;
        int[] longestSequence = {};

        for (int[] row : matrix) {
            int currentLength = 1;
            int[] currentSequence = {row[0]}; // Initialize with the first element
            for (int i = 1; i < row.length; i++) {
                if (row[i] > row[i - 1]) {
                    currentLength++;
                    int[] newSequence = new int[currentLength];
                    System.arraycopy(currentSequence, 0, newSequence, 0, currentLength - 1);
                    newSequence[currentLength - 1] = row[i];
                    currentSequence = newSequence;
                } else {
                    currentLength = 1;
                    currentSequence = new int[]{row[i]};
                }
            }

            if (currentLength > longestSequenceLength) {
                longestSequenceLength = currentLength;
                longestSequence = currentSequence;
            }
        }

        System.out.println("Longest increasing sequence in rows:");

        for (int num : longestSequence) {
            System.out.print(num + " ");
        }
    }
}