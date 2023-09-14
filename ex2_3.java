package ex2_3;
import java.util.Scanner;
import java.lang.Math;

/**
 * exercise2_3
 * @author Vitalii Reshetnyk
 */public class ex2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextFloat();
        double y = scanner.nextFloat();

        double ans = Math.sqrt(x*y);

        System.out.printf("%f\n", ans);
        System.out.printf("%e\n", ans);

        scanner.close();
    }
}
