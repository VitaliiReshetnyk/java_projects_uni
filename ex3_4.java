package ex3_4;
/**
 * 2theme
 * exercise3_4
 * @author Vitalii Reshetnyk
 */public class ex3_4 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Wrong input!");
        }
        else
        {

            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int z = Integer.parseInt(args[2]);

            if (((x==y)||(y==z)||(z==x)) && !(x==y && y==z))
            {
                System.out.println("2");
            }
            else
            {
                if (x==y && y==z)
                {
                    System.out.println("1");
                }
                else
                {
                    System.out.println("3");
                }
            }
        }
    }
}
