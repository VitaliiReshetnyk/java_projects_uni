package ex3_2;
import java.util.Random;
/**
 * 2theme
 * exercise3_2
 * @author Vitalii Reshetnyk
 */public class ex3_2 {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt();
        int min = a;
        int max = a;

        for (int i = 0; i < 24; i++)
        {
            a = random.nextInt();
            if (min > a)
            {
                min = a;
            }
            if (max < a)
            {
                max = a;
            }
        }
        System.out.println("Min");
        System.out.println(min);
        System.out.println("Max");
        System.out.println(max);
    }
}
