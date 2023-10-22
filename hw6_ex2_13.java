package ex2_13;
import java.util.Scanner;
/**
 * 3theme hw6
 * exercise2_13
 * @author Vitalii Reshetnyk
 */public class ex2_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();

            }
        }


        System.out.println("Original matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }


        transformMatrix(matrix);

        System.out.println("Transformed matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static void transformMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int nonZeroIndex = 0;

            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] != 0) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][nonZeroIndex];
                    matrix[i][nonZeroIndex] = temp;
                    nonZeroIndex++;
                }
            }
        }
    }
}
