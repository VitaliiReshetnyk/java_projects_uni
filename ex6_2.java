package ex6_2;

import java.io.*;
/**
 * 6theme
 * exercise6_2
 * @author Vitalii Reshetnyk
 */
public class ex6_2 {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Projects\\javaproject\\src\\file1.txt";
        String outputFilePath = "C:\\Projects\\javaproject\\src\\file2.txt";
        try {
            double product = 1.0;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    double number = Double.parseDouble(line);
                    if (number != 0) {
                        product *= Math.abs(number);
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("Product of abs non-zero numbers: " + product);
            }

            System.out.println("product was written in the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
