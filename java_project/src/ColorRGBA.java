import java.util.Scanner;

/**
 * Represents parent class.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 *
 * Bitwise operations can be applied to int values
 */


/**
 * ColorRGBA
 * Represents RGBA color, a subclass of Color.
 */
class ColorRGBA extends Color {
    /**
     * RGBA color components.
     */

    private int red;
    private int green;
    private int blue;
    private int alpha;

    /**
     * Constructor for ColorRGBA.
     * @param red Red component.
     * @param green Green component.
     * @param blue Blue component.
     * @param alpha Alpha (transparency) component.
     */
    public ColorRGBA(int red, int green, int blue, int alpha) {
        this.red = Math.min(Math.max(red, 0), 255);
        this.green = Math.min(Math.max(green, 0), 255);
        this.blue = Math.min(Math.max(blue, 0), 255);
        this.alpha = Math.min(Math.max(alpha, 0), 255);
    }

    /**
     * Getter for red component.
     * @return red component.
     */
    public int getRed() {
        return red;
    }
    /**
     * Getter for green component.
     * @return green component.
     */
    public int getGreen() {
        return green;
    }
    /**
     * Getter for blue component.
     * @return blue component.
     */
    public int getBlue() {
        return blue;
    }
    /**
     * Getter for alpha component.
     * @return alpha component.
     */
    public int getAlpha() {
        return alpha;
    }


    /**
     * Setter for red component.
     * @param red Red component.
     */
    public void setRed(int red) {
        this.red = Math.min(Math.max(red, 0), 255);
    }

    /**
     * Setter for green component.
     * @param green Green component.
     */
    public void setGreen(int green) {
        this.green = Math.min(Math.max(green, 0), 255);
    }
    /**
     * Setter for blue component.
     * @param blue Blue component.
     */
    public void setBlue(int blue) {
        this.blue = Math.min(Math.max(blue, 0), 255);
    }
    /**
     * Setter for alpha component.
     * @param alpha Alpha component.
     */
    public void setAlpha(int alpha) {
        this.alpha = Math.min(Math.max(alpha, 0), 255);
    }

    /**
     * put all params in string for easy printing
     * @return a string represantion of object
     */
    @Override
    public String toString() {
        return "ColorRGBA{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", alpha=" + alpha +
                '}';
    }

    /**
     * Additional constructor for console input
     * @param scanner uses as input
     */
    public static ColorRGBA inputColorRGBA(Scanner scanner) {
        System.out.println("Enter RGBA values (e.g., 255 0 0 255): ");
        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();
        int a = scanner.nextInt();

        return new ColorRGBA(r, g, b, a);
    }

    /**
     * Bitwise intersection of two colors (override)
     * @param other object of same class
     * @return object of same class with values bitwise intersection of two classes
     */
    @Override
    public ColorRGBA bitwiseIntersection(Color other) {
        if (other instanceof ColorRGBA) {
            ColorRGBA otherRGBA = (ColorRGBA) other;
            return new ColorRGBA(
                    this.red & otherRGBA.red,
                    this.green & otherRGBA.green,
                    this.blue & otherRGBA.blue,
                    this.alpha & otherRGBA.alpha
            );
        }
        return new ColorRGBA(0, 0, 0, 0); // Default behavior for other color types
    }


    /**
     * Bitwise XOR of two colors (override)
     * @param other object of same class
     * @return object of same class with values bitwise XOR of two classes
     */
    @Override
    public ColorRGBA bitwiseXOR(Color other) {
        if (other instanceof ColorRGBA) {
            ColorRGBA otherRGBA = (ColorRGBA) other;
            return new ColorRGBA(
                    this.red ^ otherRGBA.red,
                    this.green ^ otherRGBA.green,
                    this.blue ^ otherRGBA.blue,
                    this.alpha ^ otherRGBA.alpha
            );
        }
        return new ColorRGBA(0, 0, 0, 0); // Default behavior for other color types
    }

    /**
     * Bitwise union of two colors (override)
     * @param other object of same class
     * @return object of same class with values bitwise union of two classes
     */
    @Override
    public ColorRGBA bitwiseUnion(Color other) {
        if (other instanceof ColorRGBA) {
            ColorRGBA otherRGBA = (ColorRGBA) other;
            return new ColorRGBA(
                    this.red | otherRGBA.red,
                    this.green | otherRGBA.green,
                    this.blue | otherRGBA.blue,
                    this.alpha | otherRGBA.alpha
            );
        }
        return new ColorRGBA(0, 0, 0, 0); // Default behavior for other color types
    }

    /**
     * Mean of two objects
     * @param other object of same class
     * @return object of same class with values mean of two classes
     */
    @Override
    public ColorRGBA mixColors(Color other) {
        if (other instanceof ColorRGBA) {
            ColorRGBA otherRGBA = (ColorRGBA) other;
            return new ColorRGBA(
                    (this.red + otherRGBA.red)/2,
                    (this.green + otherRGBA.green)/2,
                    (this.blue + otherRGBA.blue)/2,
                    (this.alpha + otherRGBA.alpha)/2
            );
        }
        return new ColorRGBA(0, 0, 0, 0); // Default behavior for other color types
    }

    /**
     * Get the integer value representation of the color (override)
     * @return integer representing objects values
     */
    @Override
    public int getValueInt() {
        return (this.alpha << 24) | (red << 16) | (this.green << 8) | this.blue;
    }

    /**
     * Get the float value representation of the color (override)
     * @return float representing objects values
     */
    @Override
    public float getValueFloat() {
        return (float) (Math.sqrt((this.alpha-255)*(this.alpha-255)+(this.red-255)*(this.red-255)+(this.green-255)*(this.green-255)+(this.blue-255)*(this.blue-255))/510);
    }

    /**
     * Method to return a formatted string representation
     * @return string
     */
    public String toStringFormatted() {
        return String.format("RGBA %d %d %d %d", getRed(), getGreen(), getBlue(), getAlpha());
    }

    /**a
     * Method to set parameters from a formatted string
     * @param formattedString string where stored type and values
     */
    public void setFromFormattedString(String formattedString) {
        // Assuming the string is in the format "RGBA R G B A"
        String[] components = formattedString.split("\\s+");
        setRed(Integer.parseInt(components[1]));
        setGreen(Integer.parseInt(components[2]));
        setBlue(Integer.parseInt(components[3]));
        setAlpha(Integer.parseInt(components[4]));
    }

    /**
     * Converts the RGBA color to an equivalent XYZ color.
     * @return ColorXYZ equivalent of the current RGBA color.
     */
    public ColorXYZ toColorXYZ() {
        // Convert RGBA to XYZ
        float r = this.red / 255.0f;
        float g = this.green / 255.0f;
        float b = this.blue / 255.0f;

        // Apply gamma correction
        r = (r > 0.04045f) ? (float) Math.pow((r + 0.055f) / 1.055f, 2.4f) : r / 12.92f;
        g = (g > 0.04045f) ? (float) Math.pow((g + 0.055f) / 1.055f, 2.4f) : g / 12.92f;
        b = (b > 0.04045f) ? (float) Math.pow((b + 0.055f) / 1.055f, 2.4f) : b / 12.92f;

        // Convert to XYZ using the D65 illuminant
        float x = r * 0.4124564f + g * 0.3575761f + b * 0.1804375f;
        float y = r * 0.2126729f + g * 0.7151522f + b * 0.0721750f;
        float z = r * 0.0193339f + g * 0.1191920f + b * 0.9503041f;

        return new ColorXYZ(x, y, z);
    }

    /**
     * Converts the RGBA color to an equivalent CMYK color.
     * @return ColorCMYK equivalent of the current RGBA color.
     */
    public ColorCMYK toColorCMYK() {
        // Convert RGBA to CMYK
        float c = 1 - (float) this.red / 255.0f;
        float m = 1 - (float) this.green / 255.0f;
        float y = 1 - (float) this.blue / 255.0f;
        float k = 1 - (float) this.alpha / 255.0f;

        return new ColorCMYK(c, m, y, k);
    }

    /**
     * Converts the RGBA color to an equivalent HSB color.
     * @return ColorHSB equivalent of the current RGBA color.
     */
    public ColorHSB toColorHSB() {
        float r = this.red / 255.0f;
        float g = this.green / 255.0f;
        float b = this.blue / 255.0f;

        float max = Math.max(Math.max(r, g), b);
        float min = Math.min(Math.min(r, g), b);

        float delta = max - min;

        float hue = 0;
        float saturation = (max == 0) ? 0 : delta / max;
        float brightness = max;

        if (delta != 0) {
            if (max == r) {
                hue = (g - b) / delta + ((g < b) ? 6 : 0);
            } else if (max == g) {
                hue = (b - r) / delta + 2;
            } else if (max == b) {
                hue = (r - g) / delta + 4;
            }

            hue /= 6;
        }

        return new ColorHSB(
                hue * 360,
                saturation * 100,
                brightness * 100
        );
    }

}
