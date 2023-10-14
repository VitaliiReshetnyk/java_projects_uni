package ex2_2;

import java.util.Scanner;

/**
 * exercise2_2
 * @author Vitalii Reshetnyk
 */public class ex2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        a <<= 1;
        while (a > 0)
        {
            a >>= 1;
            System.out.println(Integer.toBinaryString(a));
        }


        scanner.close();
    }
}
