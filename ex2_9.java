package ex2_9;
import java.util.Scanner;

/**
 * 2theme
 * exercise2_9
 * @author Vitalii Reshetnyk
 */public class ex2_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        byte k = scanner.nextByte();
        System.out.println((m>>k)%2);
        scanner.close();
    }
}
