package ex4_1;
import java.util.HashMap;
import java.util.Map;


/**
 * 2theme
 * exercise4_1
 * @author Vitalii Reshetnyk
 */public class ex4_1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong input!");
        }
        else {
            int p_orig, q_orig;
            p_orig = Integer.parseInt(args[0]);
            q_orig = Integer.parseInt(args[1]);
            //p_orig = 8639;
            //q_orig = 70000;
            if (p_orig < q_orig) {
                int p = p_orig;
                int q = q_orig;

                Map<Integer, int[]> vertices = new HashMap<>();
                String sum = "0.";

                int r = 0;
                int k = 0;
                for (int i = 0; i < 100; i++) {
                    k = 0;
                    while (p < q) {
                        p *= 10;
                        k += 1;
                    }
                    r = p % q;

                    if (!vertices.containsKey(p)) {
                        vertices.put(p, new int[]{r, p / q, 1, k});
                    } else {
                        if (vertices.get(p)[2] == 2) {
                            break;
                        }
                        vertices.get(p)[2] += 1;
                    }
                    p = r;
                }

                int t = 0;
                for (int i = 0; i < vertices.size(); i++) {
                    while (!vertices.containsKey(p)) {
                        p *= 10;
                    }
                    int[] values = vertices.get(p);
                    int a = values[0];
                    int b = values[1];
                    int c = values[2];
                    int d = values[3];
                    p = a * 10;

                    if (c == 2 && t == 0) {
                        sum += " (";
                        t = 1;
                    }
                    if (d > 0) {
                        for (int j = 0; j < d - 1; j++) {
                            sum += "0";
                        }
                    }
                    sum += b;
                }

                sum += ")";
                System.out.println(sum);
            }
            else
            {
                System.out.println("Wrong input(numbers)!");
            }
        }

    }
 }
