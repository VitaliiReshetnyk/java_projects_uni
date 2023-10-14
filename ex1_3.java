package ex1_3;
import java.util.Scanner;
/**
 * 3theme
 * exercise1_3
 * @author Vitalii Reshetnyk
 */public class ex1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of values (n): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please next time enter a positive integer for n.");
        }
        else {
            double[] values = new double[n];

            System.out.println("Enter " + n + " real numbers:");

            for (int i = 0; i < n; i++) {
                System.out.print("Enter value " + (i + 1) + ": ");
                values[i] = scanner.nextDouble();
            }

            double sum = 0;
            for (double value : values) {
                sum += value;
            }
            double mean = sum / n;

            double sumOfSquaredDifferences = 0;
            for (double value : values) {
                double difference = value - mean;
                sumOfSquaredDifferences += difference * difference;
            }
            double sampleStandardDeviation = Math.sqrt(sumOfSquaredDifferences / (n - 1));

            System.out.println("Mean (average): " + mean);
            System.out.println("Sample Standard Deviation: " + sampleStandardDeviation);
        }
        scanner.close();
    }
}
