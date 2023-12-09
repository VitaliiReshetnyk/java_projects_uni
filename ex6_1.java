package ex6_1;
import java.io.*;
/**
 * 6theme
 * exercise6_1
 * @author Vitalii Reshetnyk
 */


public class ex6_1 {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Projects\\javaproject\\src\\file1.txt";
        String outputFilePath = "C:\\Projects\\javaproject\\src\\file2.txt";

        try {
            double sum = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    double number = Double.parseDouble(line);
                    sum += number;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("Sum: " + sum);
            }

            System.out.println("Sum of float numbers was written in file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
