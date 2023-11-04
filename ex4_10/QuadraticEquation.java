package ex4_10;
import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

/**
 * 4theme
 * exercise4_10
 * @author Vitalii Reshetnyk
 */

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solve() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two real roots: Root1 = " + root1 + ", Root2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("One real root: Root = " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("Complex roots: Root1 = " + realPart + " + " + imaginaryPart + "i, Root2 = " + realPart + " - " + imaginaryPart + "i");
        }
    }

    public double[] getRoots() {
        double discriminant = b * b - 4 * a * c;
        double[] roots = new double[2];

        if (discriminant > 0) {
            roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            roots[0] = -b / (2 * a);
            roots[1] = roots[0]; // Repeated root
        } else {
            // Complex roots; set them to NaN
            roots[0] = Double.NaN;
            roots[1] = Double.NaN;
        }

        return roots;
    }

    public static class QuadraticInequality {
        private double a;
        private double b;
        private double c;
        private String inequality;

        public QuadraticInequality(double a, double b, double c, String inequality) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.inequality = inequality;
        }

        public boolean isSatisfied(double x) {
            double y = a * x * x + b * x + c;
            switch (inequality) {
                case "<":
                    return y < 0;
                case "<=":
                    return y <= 0;
                case ">":
                    return y > 0;
                case ">=":
                    return y >= 0;
                default:
                    return false;
            }
        }
    }

    public static void main(String[] args) {
        List<QuadraticEquation> equations = new ArrayList<>();

        equations.add(new QuadraticEquation(1, -3, 2));
        equations.add(new QuadraticEquation(1, 2, 1));
        equations.add(new QuadraticEquation(1, 0, -1));

        double smallestRoot = Double.POSITIVE_INFINITY;
        double largestRoot = Double.NEGATIVE_INFINITY;

        for (QuadraticEquation equation : equations) {
            double[] roots = equation.getRoots();
            for (double root : roots) {
                if (!Double.isNaN(root)) {
                    smallestRoot = Math.min(smallestRoot, root);
                    largestRoot = Math.max(largestRoot, root);
                }
            }
        }

        System.out.println("Smallest Root: " + smallestRoot);
        System.out.println("Largest Root: " + largestRoot);








        List<QuadraticInequality> inequalities = new ArrayList<>();
        inequalities.add(new QuadraticInequality(1, -3, 2, ">="));  // x^2 - 3x + 2 >= 0
        inequalities.add(new QuadraticInequality(1, 2, 1, ">="));   // x^2 + 2x + 1 >= 0
        inequalities.add(new QuadraticInequality(1, 0, -1, "<="));  // x^2 - 1 <= 0

        // Determine valid intervals
        for (QuadraticInequality inequality : inequalities) {
            List<String> validIntervals = new ArrayList<>();
            for (int x = -100; x <= 100; x++) {
                if (inequality.isSatisfied(x)) {
                    validIntervals.add(String.valueOf(x));
                    while (x <= 100 && inequality.isSatisfied(x)) {
                        x++;
                    }
                    validIntervals.add(String.valueOf(x - 1));
                }
            }

            System.out.println("Valid intervals for " + inequality.inequality + " " + inequality.a + "x^2 + " + inequality.b + "x + " + inequality.c + ": " + validIntervals);
        }
    }
}







