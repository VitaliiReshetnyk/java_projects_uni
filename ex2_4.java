package ex2_4;

import java.util.Scanner;

/**
 * 3theme
 * exercise2_4
 * @author Vitalii Reshetnyk
 */public class ex2_4 {

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
        findAndPrintSumBetweenPositiveElements(matrix);
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



    private static void findAndPrintSumBetweenPositiveElements(int[][] matrix) {
        for (int[] row : matrix) {
            int firstPositiveIndex = -1;
            int secondPositiveIndex = -1;
            int sum = 0;

            for (int i = 0; i < row.length; i++) {
                if (row[i] > 0) {
                    if (firstPositiveIndex == -1) {
                        firstPositiveIndex = i;
                    } else if (secondPositiveIndex == -1) {
                        secondPositiveIndex = i;
                        break;
                    }
                }
            }

            if (firstPositiveIndex != -1 && secondPositiveIndex != -1) {
                for (int i = firstPositiveIndex + 1; i < secondPositiveIndex; i++) {
                    sum += row[i];
                }

                System.out.println("Sum between first and second positive elements in row: " + sum);
            } else {
                System.out.println("No valid sequence of positive elements found in this row.");
            }
        }
    }

}

