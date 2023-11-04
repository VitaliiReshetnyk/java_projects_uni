package ex4_1;

import java.util.ArrayList;
import java.util.List;


public class ex4_1 {
    /**
     * 4theme
     * exercise4_1
     * @author Vitalii Reshetnyk
     */
    public static void main(String[] args) {
        int n = 3; // Number of polynomials
        List<Polynomial> polynomials = new ArrayList<>();

        // Create and initialize polynomials
        Polynomial poly1 = new Polynomial();
        poly1.addCoefficient(new RationalFraction(1, 2));
        poly1.addCoefficient(new RationalFraction(3, 4));
        poly1.addCoefficient(new RationalFraction(1, 3));
        polynomials.add(poly1);

        Polynomial poly2 = new Polynomial();
        poly2.addCoefficient(new RationalFraction(2, 1));
        poly2.addCoefficient(new RationalFraction(1, 2));
        polynomials.add(poly2);

        Polynomial poly3 = new Polynomial();
        poly3.addCoefficient(new RationalFraction(3, 5));
        poly3.addCoefficient(new RationalFraction(2, 3));
        poly3.addCoefficient(new RationalFraction(5, 6));
        polynomials.add(poly3);

        // Calculate the sum of polynomials
        Polynomial sum = new Polynomial();
        for (Polynomial polynomial : polynomials) {
            for (int i = 0; i < polynomial.coefficients.size(); i++) {
                if (i >= sum.coefficients.size()) {
                    sum.coefficients.add(new RationalFraction(0, 1));
                }
                sum.coefficients.get(i).add(polynomial.coefficients.get(i));
            }
        }

        // Display the sum of polynomials
        System.out.println("Sum of Polynomials:");
        for (int i = 0; i < sum.coefficients.size(); i++) {
            System.out.println("Coefficient " + i + ": " + sum.coefficients.get(i));
        }
    }
}




class RationalFraction {
    int numerator;
    int denominator;

    public RationalFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void add(RationalFraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        this.numerator = newNumerator;
        this.denominator = commonDenominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

class Polynomial {
    List<RationalFraction> coefficients;

    public Polynomial() {
        coefficients = new ArrayList<>();
    }

    public void addCoefficient(RationalFraction coefficient) {
        coefficients.add(coefficient);
    }

    public RationalFraction evaluate(int x) {
        RationalFraction result = new RationalFraction(0, 1);

        for (int i = 0; i < coefficients.size(); i++) {
            RationalFraction term = coefficients.get(i);
            RationalFraction xTerm = new RationalFraction((int) Math.pow(x, i), 1);
            term.add(xTerm);
            result.add(term);
        }

        return result;
    }
}
