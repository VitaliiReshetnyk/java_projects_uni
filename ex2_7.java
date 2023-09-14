package ex2_7;

/**
 * exercise2_3
 * @author Vitalii Reshetnyk
 */public class ex2_7 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong input!");
        }
        else
        {

            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int z = x*y;
            System.out.println(z);
        }
    }
}
