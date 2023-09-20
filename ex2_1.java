package ex2_1;

/**
 * exercise2_1
 * @author Vitalii Reshetnyk
 */public class ex2_1 {
    public static void main(String[] args) {
    int a = 42;
    int b = 85;

    int c = a&b;
    int d = a|b;
    int e = a^b;
    int f = ~b;
    int g = a >> 1;
    int h = b << 1;

    int k = -10;
    int k1 = k >>> 2;
    int k2 = k << 2;

    System.out.println(Integer.toBinaryString(a));
    System.out.println(Integer.toBinaryString(b));
    System.out.println(Integer.toBinaryString(c));
    System.out.println(Integer.toBinaryString(d));
    System.out.println(Integer.toBinaryString(e));
    System.out.println(Integer.toBinaryString(f));
    System.out.println(Integer.toBinaryString(g));
    System.out.println(Integer.toBinaryString(h));
    System.out.println(Integer.toBinaryString(k));
    System.out.println(Integer.toBinaryString(k1));
    System.out.println(k1);
    System.out.println(k2);
    System.out.println("end");
    }
}
