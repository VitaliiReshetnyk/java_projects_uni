package ex3_6;
import java.util.Random;
/**
 * 2theme
 * exercise3_4
 * @author Vitalii Reshetnyk
 */public class ex3_6 {
    public static void main(String[] args) {
        Random random = new Random();


        int a = 0;
        int b = 0;
        int t = 10000;
        for (int i = 0; i < t; i++)
        {
            boolean current = random.nextBoolean();
            boolean prev = false;
            int j = 0;
            for (j = 1; !(current && prev); j++)
            {
                prev = current;
                current = random.nextBoolean();
            }



            boolean current_b = random.nextBoolean();;
            boolean prev_b = false;

            int k = 0;
            for (k = 1; !(!(current_b) && prev_b); k++)
            {
                prev_b = current_b;
                current_b = random.nextBoolean();
            }

            if (j < k)
            {
                a++;
            }
            if (j > k) {
                b++;
            }
        }
        //System.out.println(a);
        //System.out.println(b);
        System.out.println(((float)a)/t);
        System.out.println(39./121);
        //39/121


    }
}
