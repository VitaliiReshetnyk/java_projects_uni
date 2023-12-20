import java.util.Scanner;

/**
 * Represents class to store in matrix colors.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 */
public class Image {
    private int m, n; // Dimensions of the image
    private ColorRGBA[][] pixels; // Two-dimensional matrix to store ColorRGBA objects
    /**
     * Constructs an Image object with the specified dimensions.
     * @param m Width of the image.
     * @param n Height of the image.
     */
    public Image(int m, int n) {
        this.m = m;
        this.n = n;
        this.pixels = new ColorRGBA[m][n];
        initializePixels(); // Initialize the pixels with default Color values
    }

    /**
     * Get the width of the image.
     * @return Width of the image.
     */
    public int getWidth() {
        return m;
    }
    /**
     * Get the height of the image.
     * @return Height of the image.
     */
    public int getHeight() {
        return n;
    }
    /**
     * Get the color of a specific pixel.
     * @param x X-coordinate of the pixel.
     * @param y Y-coordinate of the pixel.
     * @return Color of the specified pixel.
     * @throws IllegalArgumentException if the pixel coordinates are invalid.
     */
    public ColorRGBA getPixel(int x, int y) {
        if (isValidPixel(x, y)) {
            return pixels[x][y];
        } else {
            throw new IllegalArgumentException("Invalid pixel coordinates");
        }
    }

    /**
     * Set the color of a specific pixel.
     * @param x X-coordinate of the pixel.
     * @param y Y-coordinate of the pixel.
     * @param color Color to set for the pixel.
     * @throws IllegalArgumentException if the pixel coordinates are invalid.
     */
    public void setPixel(int x, int y, ColorRGBA color) {
        if (isValidPixel(x, y)) {
            this.pixels[x][y] = color;
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
     * Initialize pixels with default Color values
     */
    private void initializePixels() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pixels[i][j] = new ColorRGBA(0, 0, 0, 255); // Default color is black with full opacity
            }
        }
    }




    /**
     * Method to input values from the console for the Image.
     * @param scanner Scanner object for user input.
     * @return Image object with user-specified values.
     */
    public static Image inputImage(Scanner scanner) {
        System.out.println("Enter dimensions of the image (m n): ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        Image image = new Image(m, n);

        System.out.println("Enter pixel values for the image (RGBA format): ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int red = scanner.nextInt();
                int green = scanner.nextInt();
                int blue = scanner.nextInt();
                int alpha = scanner.nextInt();
                ColorRGBA color = new ColorRGBA(red, green, blue, alpha);
                image.setPixel(i, j, color);
            }
        }

        return image;
    }

    /**
     * Method to output values to the console for the Image.
     */
    public void outputImage() {
        System.out.println("Image dimensions: " + getWidth() + " x " + getHeight());
        System.out.println("Pixel values (RGBA format):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ColorRGBA color = getPixel(i, j);
                System.out.print(color.toStringFormatted() + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
