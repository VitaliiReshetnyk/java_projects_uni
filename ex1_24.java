package ex1_24;
import java.util.Scanner;
/**
 * 3theme
 * exercise1_24
 * @author Vitalii Reshetnyk
 */public class ex1_24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int W = scanner.nextInt();
        int[] weights = new int[N];

        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
        }

        int maxWeight = findMaxWeight(weights, N, W, 0);

        System.out.println("Maximum total weight: " + maxWeight);

        scanner.close();
    }

    public static int findMaxWeight(int[] weights, int N, int remainingWeight, int currentIndex) {
        if (currentIndex == N || remainingWeight == 0) {
            return 0;
        }

        if (weights[currentIndex] > remainingWeight) {
            return findMaxWeight(weights, N, remainingWeight, currentIndex + 1);
        }

        int includeCurrent = weights[currentIndex] + findMaxWeight(weights, N, remainingWeight - weights[currentIndex], currentIndex + 1);
        int excludeCurrent = findMaxWeight(weights, N, remainingWeight, currentIndex + 1);

        return Math.max(includeCurrent, excludeCurrent);
    }
}
