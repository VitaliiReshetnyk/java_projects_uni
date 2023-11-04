package ex3_1;
import java.util.Scanner;


public class ex3_1 {
    /**
     * 4theme
     * exercise3_1
     * @author Vitalii Reshetnyk
     */
    public static void main(String[] args) {
        int k = 5;
        RationalFraction[] fractions = new RationalFraction[k];

        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < k; i++)
        {
            System.out.println("K:" + (i+1));
            System.out.print("num:");
            int num = scanner.nextInt();
            System.out.print("dem:");
            int dem = scanner.nextInt();
            fractions[i] = new RationalFraction(num, dem);
        }
        scanner.close();



        System.out.println("Original Fractions:");
        for (RationalFraction fraction : fractions) {
            System.out.println(fraction);
        }

        for (int i = 0; i < k - 1; i++) {
            fractions[i].addFollowingFraction(fractions[i + 1]);
        }

        System.out.println("\nUpdated Fractions:");
        for (RationalFraction fraction : fractions) {
            System.out.println(fraction);
        }
    }
}


class RationalFraction {
    private int numerator;
    private int denominator;

    public RationalFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public void addFollowingFraction(RationalFraction followingFraction) {
        int commonDenominator = this.denominator * followingFraction.denominator;
        int newNumerator = this.numerator * followingFraction.denominator + followingFraction.numerator * this.denominator;
        this.numerator = newNumerator;
        this.denominator = commonDenominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}




