package ex6_3;
import java.io.*;
/**
 * 6theme
 * exercise6_3
 * @author Vitalii Reshetnyk
 */
public class ex6_3 {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Projects\\javaproject\\src\\file1.txt";
        String outputFilePath = "C:\\Projects\\javaproject\\src\\file2.txt";

        try {
            long product = 1;

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int number = Integer.parseInt(line);
                    if (number % 2 == 0) {
                        product *= number;
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("The product of even elements: " + product);
            }

            System.out.println("The product of even elements was successfully written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
