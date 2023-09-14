package ex2_2;
import java.util.Scanner;
import java.lang.Math;

/**
 * exercise2_2
 * @author Vitalii Reshetnyk
 */public class ex2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int a = ((int)Math.log10((double) x)) + 1;
        int b = String.valueOf(y).length();
        System.out.println(a+1);
        System.out.println(b);

        double ans = 2/(1/(double)x+1/(double)y);
        System.out.printf("%.2f", ans);

        scanner.close();
    }
}
