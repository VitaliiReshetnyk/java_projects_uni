package ex2_2;
import java.util.Scanner;
import java.util.Random;

/**
 * 3theme
 * exercise2_2
 * @author Vitalii Reshetnyk
 */public class ex2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter the number of rows (m): ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of columns (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];

        System.out.println("Enter the matrix elements:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");

                matrix[i][j] = rand.nextInt(201) - 100;
                System.out.println("Element at position (" + (i + 1) + ", " + (j + 1) + "): " + matrix[i][j]);

            }
        }

        System.out.print("Enter the number of positions to shift (k): ");
        int k = scanner.nextInt();

        // Perform cyclic shifts
        int[][] shiftedMatrixLeft = cyclicShiftLeft(matrix, k);
        int[][] shiftedMatrixRight = cyclicShiftRight(matrix, k);
        int[][] shiftedMatrixUp = cyclicShiftUp(matrix, k);
        int[][] shiftedMatrixDown = cyclicShiftDown(matrix, k);

        System.out.println("Cyclically NOT shifted matrix:");
        printMatrix(matrix);


        System.out.println("Cyclically shifted matrix left by " + k + " positions:");
        printMatrix(shiftedMatrixLeft);

        System.out.println("Cyclically shifted matrix right by " + k + " positions:");
        printMatrix(shiftedMatrixRight);

        System.out.println("Cyclically shifted matrix up by " + k + " positions:");
        printMatrix(shiftedMatrixUp);

        System.out.println("Cyclically shifted matrix down by " + k + " positions:");
        printMatrix(shiftedMatrixDown);

        scanner.close();
    }

    // Method to perform cyclic shift left
    private static int[][] cyclicShiftLeft(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] shiftedMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newCol = (j - k) % n;
                if (newCol < 0) {
                    newCol += n;
                }
                shiftedMatrix[i][newCol] = matrix[i][j];
            }
        }

        return shiftedMatrix;
    }

    // Method to perform cyclic shift right
    private static int[][] cyclicShiftRight(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] shiftedMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newCol = (j + k) % n;
                shiftedMatrix[i][newCol] = matrix[i][j];
            }
        }

        return shiftedMatrix;
    }

    // Method to perform cyclic shift up
    private static int[][] cyclicShiftUp(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] shiftedMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            int newRow = (i - k) % m;
            if (newRow < 0) {
                newRow += m;
            }
            for (int j = 0; j < n; j++) {
                shiftedMatrix[newRow][j] = matrix[i][j];
            }
        }

        return shiftedMatrix;
    }

    // Method to perform cyclic shift down
    private static int[][] cyclicShiftDown(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] shiftedMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            int newRow = (i + k) % m;
            for (int j = 0; j < n; j++) {
                shiftedMatrix[newRow][j] = matrix[i][j];
            }
        }

        return shiftedMatrix;
    }

    // Method to print a matrix
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
}