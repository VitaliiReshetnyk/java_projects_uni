package ex3_9;

import java.util.Arrays;

/**
 * 2theme
 * exercise3_9
 * @author Vitalii Reshetnyk
 */public class ex3_9 {
    public static void main(String[] args){
        if (args.length != 6) {
            System.out.println("Wrong input!");
        }
        else
        {

            float a = Float.parseFloat(args[0]);
            float b = Float.parseFloat(args[1]);
            float c = Float.parseFloat(args[2]);
            float d = Float.parseFloat(args[3]);
            float e = Float.parseFloat(args[4]);
            float f = Float.parseFloat(args[5]);

            float k[] = {a, b, c, d, e, f};
            Arrays.sort(k);

            System.out.println((k[1]+k[2]+k[3]+k[4])/4);

        }
    }
}
