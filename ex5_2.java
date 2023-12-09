package ex5_2;

/**
 * 6theme
 * exercise5_2
 * @author Vitalii Reshetnyk
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ex5_2 {
    public static void main(String[] args) {
        String filePath = "C:\\Projects\\javaproject\\src\\input.txt";

        try {
            int emptyLinesCount = countEmptyLines(filePath);
            System.out.println("Amount of empty rows: " + emptyLinesCount);

            int maxLineLength = getMaxLineLength(filePath);
            System.out.println("Мax length of row: " + maxLineLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countEmptyLines(String filePath) throws IOException {
        int emptyLinesCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    emptyLinesCount++;
                }
            }
        }
        return emptyLinesCount;
    }
    private static int getMaxLineLength(String filePath) throws IOException {
        int maxLineLength = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int lineLength = line.length();
                if (lineLength > maxLineLength) {
                    maxLineLength = lineLength;
                }
            }
        }

        return maxLineLength;
    }
}