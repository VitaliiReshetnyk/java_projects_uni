import java.util.Scanner;

/**
 * exercise1_6
 * @author Vitalii Reshetnyk
 */public class exercise1_6
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        float x = scanner.nextFloat();
        float y = scanner.nextFloat();
        float z = scanner.nextFloat();

        float sum = x+y+z;
        System.out.println("sum=" + sum);
        scanner.close();
    }
}