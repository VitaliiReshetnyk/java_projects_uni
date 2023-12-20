import java.util.Scanner;

/**
 * Represents class to store in matrix gray colors.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 */
public class Mask {
    private int m, n; // Dimensions of the mask
    private int[][] pixels; // Two-dimensional matrix to store mask values
    /**
     * Constructs a Mask object with the specified dimensions.
     * @param m Width of the mask.
     * @param n Height of the mask.
     */
    public Mask(int m, int n) {
        this.m = m;
        this.n = n;
        this.pixels = new int[m][n];
        initializePixels(); // Initialize the pixels with default values
    }

    /**
     * Get the width of the mask.
     * @return Width of the mask.
     */
    public int getWidth() {
        return m;
    }
    /**
     * Get the height of the mask.
     * @return Height of the mask.
     */
    public int getHeight() {
        return n;
    }

    /**
     * Set the value of a specific pixel in the mask.
     * @param x X-coordinate of the pixel.
     * @param y Y-coordinate of the pixel.
     * @param value Value to set for the pixel (0 or 1).
     * @throws IllegalArgumentException if the pixel coordinates are invalid.
     */
    public void setPixel(int x, int y, int value) {
        if (isValidPixel(x, y)) {
            pixels[x][y] = value;
        } else {
            throw new IllegalArgumentException("Invalid pixel coordinates");
        }
    }

    /**
     * Get the value of a specific pixel in the mask.
     * @param x X-coordinate of the pixel.
     * @param y Y-coordinate of the pixel.
     * @return Value of the specified pixel.
     * @throws IllegalArgumentException if the pixel coordinates are invalid.
     */
    public int getPixel(int x, int y) {
        if (isValidPixel(x, y)) {
            return pixels[x][y];
        } else {
            throw new IllegalArgumentException("Invalid pixel coordinates");
        }
    }

    /**
     * Check if the pixel coordinates are valid
     * @param x X-coordinate of the pixel.
     * @param y Y-coordinate of the pixel.
     * @returns True if the pixel coordinates are valid.
     */
    private boolean isValidPixel(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    /**
     * Initialize pixels with default values
     */
    private void initializePixels() {
        // Default value for a mask element
        int defaultValue = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pixels[i][j] = defaultValue;
            }
        }
    }

    /**
     * Method to input values from the console for the Mask.
     * @param scanner Scanner object for user input.
     * @return Mask object with user-specified values.
     */
    public static Mask inputMask(Scanner scanner) {
        System.out.println("Enter dimensions of the mask (m n): ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        Mask mask = new Mask(m, n);

        System.out.println("Enter pixel values for the mask (0 or 1): ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = scanner.nextInt();
                mask.setPixel(i, j, value);
            }
        }

        return mask;
    }

    /**
     * Method to output values to the console for the Mask.
     */
    public void outputMask() {
        System.out.println("Mask dimensions: " + getWidth() + " x " + getHeight());
        System.out.println("Pixel int values:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = getPixel(i, j);
                System.out.print(value + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
