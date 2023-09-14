package ex4_6;
import java.lang.Math;
import java.util.Scanner;

/**
 * exercise4_6 ж
 * @author Vitalii Reshetnyk
 */public class ex4_6 {
     public static double invsqrt(double x, double a)
     {
         return x/Math.sqrt(1+a*x*x);
     }
    public static double invsqrt_derivative(double x, double a)
    {
        return 1/(Math.sqrt(1+a*x*x)*(1+a*x*x));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input double x:");
        double x = scanner.nextDouble();
        System.out.println("Input double a:");
        double a = scanner.nextDouble();
        System.out.println("invsqrt of input double:" + invsqrt(x, a));
        System.out.println("invsqrt_derivative of input double:" + invsqrt_derivative(x, a));

        scanner.close();
    }
}
