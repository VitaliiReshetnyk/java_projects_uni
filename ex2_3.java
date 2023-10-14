package ex2_3;


/**
 * exercise2_3
 * @author Vitalii Reshetnyk
 */public class ex2_3 {
    public static String char_to_bin(char A)
    {
        int number = Character.getNumericValue(A);
        String ans = Integer.toBinaryString(number);

        return ans;
    }
    public static void main(String[] args) {
        char a = 'F';
        System.out.println(char_to_bin(a));
        a = 'k';
        System.out.println(char_to_bin(a));
        a = '2';
        System.out.println(char_to_bin(a));
    }
}
