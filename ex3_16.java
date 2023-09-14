package ex3_16;
import java.util.Scanner;

/**
 * exercise3_16
 * @author Vitalii Reshetnyk
 */public class ex3_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String hexNumber = scanner.nextLine();

        int dec = Integer.parseInt(hexNumber, 16);

        dec -= 1;
        System.out.println("Decimal value is " + dec);
        System.out.println("Hex value is " + Integer.toHexString(dec));

        scanner.close();
    }
}
