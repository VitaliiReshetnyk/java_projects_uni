package ex2_4;


import java.util.Scanner;

/**
 * exercise2_4
 * @author Vitalii Reshetnyk
 */public class ex2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int temp = 1<<m;
        int ans = n^temp;

        System.out.println(ans);

        
        scanner.close();
    }
}

