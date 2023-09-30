package ex4_17;
import java.util.Scanner;
/**
 * 2theme
 * exercise4_17
 * @author Vitalii Reshetnyk
 */public class ex4_17 {
    public static int factor(int a) {
        if (a <= 1)
        {
            return 1;
        }
        return a*factor(a-1);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a > 0)
        {
            int b = 1;
            int k = a;
            while (k > 0)
            {
                b*=k;
                k-=1;
            }
            System.out.println(a + "!=" + factor(a) + "=" + b);
        }
        else
        {
            System.out.println("Not a natural number!");
        }
        scanner.close();
    }
}
