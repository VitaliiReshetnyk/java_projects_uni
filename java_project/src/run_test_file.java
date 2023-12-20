import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.swing.*;

/**
 * Main file with tests using file input.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 */
public class run_test_file {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String fileName = "inputs/input1.txt";
        String OutfileName = "outputs/output1.txt";
        Path filePath = FileSystems.getDefault().getPath(fileName);
        if (!Files.exists(filePath)) {
            throw new NullPointerException("File not found: " + fileName);
        }
        List<ColorRGBA> colorList = new ArrayList<>();
        // Use try-with-resources to ensure the BufferedReader is closed properly
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line as a ColorRGBA formatted string
                ColorRGBA color = new ColorRGBA(0, 0, 0, 0);
                color.setFromFormattedString(line);
                colorList.add(color);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        //printing all colors
        for (int i = 0; i < colorList.size(); i++) {
            System.out.print(i);
            System.out.print(" ");
            System.out.print(colorList.get(i));
            System.out.print("\n");
        }

        //bitwise operations on list
        //XOR
        System.out.println("\nPerform bitwise operations for every element of list with first element ");
        System.out.println("XOR");
        List<ColorRGBA> colorList2 = new ArrayList<>();
        for (int i = 0; i < colorList.size(); i++) {
            colorList2.add(colorList.get(i).bitwiseXOR(colorList.get(0)));
            System.out.println(colorList2.get(i));
        }

        //saving result to new file
        System.out.println("\nXOR list was written to file" + OutfileName);
        try (PrintWriter writer = new PrintWriter(OutfileName)) {
            for (ColorRGBA color : colorList2) {
                writer.println(color.toStringFormatted());
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        //intersection
        System.out.println("\nIntersection");
        for (int i = 0; i < colorList.size(); i++) {
            System.out.println(colorList.get(i).bitwiseIntersection(colorList.get(0)));
        }
        //union
        System.out.println("\nUnion");
        for (int i = 0; i < colorList.size(); i++) {
            System.out.println(colorList.get(i).bitwiseUnion(colorList.get(0)));
        }
        //mix two colors
        System.out.println("\nPerform mix/mean operations for every element of list with first element ");
        for (int i = 0; i < colorList.size(); i++) {
            System.out.println(colorList.get(i).mixColors(colorList.get(0)));
        }
        //transforming color to another types
        //to XYZ
        System.out.println("\nTransform to XYZ");
        for (int i = 0; i < colorList.size(); i++) {
            System.out.println(colorList.get(i).toColorXYZ());
        }
        //to CMYK
        System.out.println("\nTransform to CMYK");
        for (int i = 0; i < colorList.size(); i++) {
            System.out.println(colorList.get(i).toColorCMYK());
        }
        //to HSB
        System.out.println("\nTransform to HSB");
        for (int i = 0; i < colorList.size(); i++) {
            System.out.println(colorList.get(i).toColorHSB());
        }

        //********
        //ALERT!!!
        //when a window is called up twice for a visual demonstration,
        // one will lie on top of the other, move the window to the side to see everything

        //Visualise using Image
        System.out.println("\nVisualise in colors");
        Image image = new Image(1, colorList.size() );
        for (int i = 0; i < colorList.size(); i++) {
            image.setPixel(0, i, colorList.get(i));
        }
        image.outputImage();
        SwingUtilities.invokeLater(() -> new ImageVisualizer(image));

        //Visualise using Mask
        System.out.println("\nVisualise in gray");
        Mask mask = new Mask(1, colorList.size() );
        for (int i = 0; i < colorList.size(); i++) {
            mask.setPixel(0, i, (int) Math.floor(colorList.get(i).getValueFloat()*255));
        }
        mask.outputMask();
        SwingUtilities.invokeLater(() -> new MaskVisualizer(mask));


        scanner.close();
    }
}
