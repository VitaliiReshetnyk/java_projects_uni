package sqreq;
import java.util.Scanner;

/**
 * @author Vitalii Reshetnyk
 */

public class sqreq {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input a coefficient: ");
        float a = in.nextFloat();
        System.out.print("Input b coefficient: ");
        float b = in.nextFloat();
        System.out.print("Input c coefficient: ");
        float c = in.nextFloat();

        try {
            if (a == 0)
                throw new ArithmeticException("a coefficient can't be zero!!!");

            double D = b*b - 4 * a * c;

            if (D < 0)
                throw new SqrnException("D is negative, no real roots!!!");

            double D_sqrt = Math.sqrt(D);
            double x1 = (-b + D_sqrt) / 2 * a;
            double x2 = (-b - D_sqrt) / 2 * a;

            System.out.println("Roots: x1=" + x1 + " x2=" + x2);

        }catch (SqrnException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}