package ex4_5;
import java.lang.Math;
import java.util.Scanner;

/**
 * exercise4_5
 * @author Vitalii Reshetnyk
 */public class ex4_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        scanner.nextLine();

        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        scanner.nextLine();

        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        scanner.nextLine();

        double a = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        double b = Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        double c = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));

        double p = (a+b+c)/2;

        double S = Math.sqrt(p*(p-a)*(p-b)*(p-c));


        System.out.printf("S = %f\n", S);

        scanner.close();


    }
}
