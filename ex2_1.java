package ex2_1;
import java.util.Scanner;

/**
 * exercise2_1
 * @author Vitalii Reshetnyk
 */public class ex2_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Input surname:");
        String name = s.nextLine();

        System.out.println("Hello, " + name);

        s.close();
    }
}
