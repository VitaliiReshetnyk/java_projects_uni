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
 * Main file with tests using console input.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 */
public class run_test_console {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Choose console or file input
        System.out.println("Choose input type (1 for console, 2 for file): ");
        int inputType = scanner.nextInt();

        if (inputType == 1) {
            // Step 2: Console input
            System.out.println("Choose color system (1 for RGBA, 2 for XYZ, 3 for CMYK, 4 for HSB): ");
            int colorSystem = scanner.nextInt();

            Color color1 = null;
            switch (colorSystem) {
                case 1:
                    color1 = ColorRGBA.inputColorRGBA(scanner);
                    break;
                case 2:
                    color1 = ColorXYZ.inputColorXYZ(scanner);
                    break;
                case 3:
                    color1 = ColorCMYK.inputColorCMYK(scanner);
                    break;
                case 4:
                    color1 = ColorHSB.inputColorHSB(scanner);
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }

            // Step 3: Perform operations
            // (Note: Assume bitwise operations only for RGBA)
            if (color1 instanceof ColorRGBA) {
                ColorRGBA rgba1 = (ColorRGBA) color1;

                System.out.println("Choose operation (1 for transform to another color system, 2 for mean of two colors, 3 for bitwise operations): ");
                int operation = scanner.nextInt();

                if (operation == 1) {
                    // Transform to another color system
                    System.out.println("Choose target color system (2 for XYZ, 3 for CMYK, 4 for HSB): ");
                    int targetSystem = scanner.nextInt();

                    switch (targetSystem) {
                        case 2:
                            ColorXYZ xyzColor = rgba1.toColorXYZ();
                            System.out.println("Transformed color: " + xyzColor);
                            break;
                        case 3:
                            ColorCMYK cmykColor = rgba1.toColorCMYK();
                            System.out.println("Transformed color: " + cmykColor);
                            break;
                        case 4:
                            ColorHSB hsbColor = rgba1.toColorHSB();
                            System.out.println("Transformed color: " + hsbColor);
                            break;
                        default:
                            System.out.println("Invalid target color system");
                            break;
                    }
                } else if (operation == 2) {
                    // Mean of two colors
                    System.out.println("Enter values for the second color (RGBA): ");
                    ColorRGBA rgba2 = ColorRGBA.inputColorRGBA(scanner);
                    ColorRGBA meanColor = rgba1.mixColors(rgba2);
                    System.out.println("Mean color: " + meanColor);
                } else {
                    if (operation == 3){
                        System.out.println("Enter values for the second color (RGBA): ");
                        ColorRGBA rgba2 = ColorRGBA.inputColorRGBA(scanner);
                        System.out.println("Choose operation 1 for bitwiseXOR, 2 for bitwiseIntersection, 3 for bitwiseUnion: ");
                        int operation3 = scanner.nextInt();
                        switch (operation3) {
                            case 1:
                                System.out.println(rgba1);
                                System.out.println("^");
                                System.out.println(rgba2);
                                System.out.println("=");
                                System.out.println(rgba1.bitwiseXOR(rgba2));
                                break;
                            case 2:
                                System.out.println(rgba1);
                                System.out.println("&");
                                System.out.println(rgba2);
                                System.out.println("=");
                                System.out.println(rgba1.bitwiseIntersection(rgba2));
                                break;
                            case 3:
                                System.out.println(rgba1);
                                System.out.println("|");
                                System.out.println(rgba2);
                                System.out.println("=");
                                System.out.println(rgba1.bitwiseUnion(rgba2));
                                break;
                            default:
                                System.out.println("Wrong input");
                                return;
                        }
                    }
                    else {
                        System.out.println("Invalid operation");
                    }
                }
            } else {
                // Step 4: Transforming colors
                System.out.println("Choose operation (1 for transform to another color system, 2 for mean of two colors): ");
                int operation = scanner.nextInt();
                if (operation == 1)
                {
                    System.out.println("Transform to another color system");
                    System.out.println("Choose target color system (1 for RGBA, 2 for XYZ, 3 for CMYK, 4 for HSB): ");
                    int targetSystem1 = scanner.nextInt();
                    if (color1 instanceof ColorXYZ)
                    {
                        ColorXYZ clr2 = (ColorXYZ) color1;
                        switch (targetSystem1)
                        {
                            case 1:
                                ColorRGBA rgbaColor = clr2.toColorRGBA();
                                System.out.println("Transformed color: " + rgbaColor);
                                break;
                            case 2:
                                System.out.println("Transformed color: " + clr2);
                                break;
                            case 3:
                                ColorCMYK cmykColor = clr2.toColorRGBA().toColorCMYK();
                                System.out.println("Transformed color: " + cmykColor);
                                break;
                            case 4:
                                ColorHSB hsbColor = clr2.toColorRGBA().toColorHSB();
                                System.out.println("Transformed color: " + hsbColor);
                                break;
                            default:
                                System.out.println("Invalid target color system");
                                return;
                        }
                    }
                    if (color1 instanceof ColorHSB)
                    {
                        ColorHSB clr2 = (ColorHSB) color1;
                        switch (targetSystem1)
                        {
                            case 1:
                                ColorRGBA rgbaColor = clr2.toColorRGBA();
                                System.out.println("Transformed color: " + rgbaColor);
                                break;
                            case 2:
                                ColorXYZ xyzColor = clr2.toColorRGBA().toColorXYZ();
                                System.out.println("Transformed color: " + xyzColor);
                                break;
                            case 3:
                                ColorCMYK cmykColor = clr2.toColorRGBA().toColorCMYK();
                                System.out.println("Transformed color: " + cmykColor);
                                break;
                            case 4:
                                System.out.println("Transformed color: " + clr2);
                                break;
                            default:
                                System.out.println("Invalid target color system");
                                return;
                        }
                    }
                    if (color1 instanceof ColorCMYK)
                    {
                        ColorCMYK clr2 = (ColorCMYK) color1;
                        switch (targetSystem1)
                        {
                            case 1:
                                ColorRGBA rgbaColor = clr2.toColorRGBA();
                                System.out.println("Transformed color: " + rgbaColor);
                                break;
                            case 2:
                                ColorXYZ xyzColor = clr2.toColorRGBA().toColorXYZ();
                                System.out.println("Transformed color: " + xyzColor);
                                break;
                            case 3:
                                System.out.println("Transformed color: " + clr2);
                                break;
                            case 4:
                                ColorHSB hsbColor = clr2.toColorRGBA().toColorHSB();
                                System.out.println("Transformed color: " + hsbColor);
                                break;
                            default:
                                System.out.println("Invalid target color system");
                                return;
                        }
                    }
                }
                else
                //Mixing colors
                {
                    if (operation == 2)
                    {
                        if (color1 instanceof ColorXYZ)
                        {
                            ColorXYZ color2 = ColorXYZ.inputColorXYZ(scanner);
                            System.out.println("Mixed color: " + color1.mixColors(color2));
                        }
                        if (color1 instanceof ColorHSB)
                        {
                            ColorHSB color2 = ColorHSB.inputColorHSB(scanner);
                            System.out.println("Mixed color: " + color1.mixColors(color2));
                        }
                        if (color1 instanceof ColorCMYK)
                        {
                            ColorCMYK color2 = ColorCMYK.inputColorCMYK(scanner);
                            System.out.println("Mixed color: " + color1.mixColors(color2));
                        }
                    }
                    else
                    {
                        System.out.println("Invalid operation");
                    }
                }
                System.out.println("Bitwise operations are only supported for RGBA colors");
            }

            // Step 5: Show visually
            System.out.println("Do you want to show the color visually? (1 for yes, 0 for no): ");
            int showVisually = scanner.nextInt();
            if (showVisually == 1) {
                System.out.println("Visual representation will be shown here.");
                Image image = new Image(1, 1);
                System.out.println("Input color you want to look at.");
                ColorRGBA show = ColorRGBA.inputColorRGBA(scanner);
                image.setPixel(0, 0, new ColorRGBA(show.getRed(), show.getGreen(), show.getBlue(), show.getAlpha()));
                SwingUtilities.invokeLater(() -> new ImageVisualizer(image));
            }

        }
        else
        {
            //step 6, read from file
            if (inputType == 2) {
                //file input
                System.out.println("Enter the absolute path of the file: ");
                String fileName = scanner.next();

                // Check if the file exists before attempting to read
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

                for (int i = 0; i < colorList.size(); i++) {
                    System.out.print("Color number ");
                    System.out.print(i);
                    System.out.print(" ");
                    System.out.print(colorList.get(i));
                    System.out.print("\n");
                }
                System.out.println("Let's for example apply bitwiseXOR for every element in list with new input color");
                ColorRGBA clr3 = ColorRGBA.inputColorRGBA(scanner);

                List<ColorRGBA> colorList2 = new ArrayList<>();

                for (int i = 0; i < colorList.size(); i++) {
                    colorList2.add(colorList.get(i).bitwiseXOR(clr3));
                    System.out.println(colorList2.get(i));
                }

                System.out.println("Let's save from list first N elements, N:");
                int N = scanner.nextInt();

                // Create a new list to store the first N elements
                List<ColorRGBA> firstNColors = colorList2.subList(0, Math.min(N, colorList.size()));

                System.out.println("Enter the absolute path of the file to write in: ");
                String newFileName = scanner.next();

                // Write the first N elements to the new file
                try (PrintWriter writer = new PrintWriter(newFileName)) {
                    for (ColorRGBA color : firstNColors) {
                        writer.println(color.toStringFormatted());
                    }
                    System.out.println("First " + N + " elements saved to " + newFileName);
                } catch (IOException e) {
                    System.err.println("Error writing to file: " + e.getMessage());
                }

                //there is no point in repeating all the functions called earlier like: show, bitwise operations, mixcolors...
            }
            else {
                System.out.println("Wrong number");
            }
        }

        //step 7: work of Image and Mask
        System.out.println("Choose (1 for work with Image, 2 for work with Mask, other for end");
        int K = scanner.nextInt();
        switch (K) {
            case 1:
                System.out.println("Image");
                Image inputImage = Image.inputImage(scanner);
                inputImage.outputImage();
                SwingUtilities.invokeLater(() -> new ImageVisualizer(inputImage));

                break;
            case 2:
                System.out.println("Mask");
                Mask inputMask = Mask.inputMask(scanner);
                inputMask.outputMask();
                SwingUtilities.invokeLater(() -> new MaskVisualizer(inputMask));

                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        scanner.close();
    }
}
