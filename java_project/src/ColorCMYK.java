import java.util.Scanner;

/**
 * Represents child class of color system CMYK.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 *
 * Bitwise operations can not be applied to float values
 */


/**
 * ColorCMYK
 * Represents CMYK color, a subclass of Color.
 */
class ColorCMYK extends Color {
    /**
     * CMYK color components.
     */
    private float cyan;
    private float magenta;
    private float yellow;
    private float black;

    /**
     * Constructor for ColorCMYK.
     * @param cyan Cyan component.
     * @param magenta Magenta component.
     * @param yellow Yellow component.
     * @param black Black component.
     */
    public ColorCMYK(float cyan, float magenta, float yellow, float black) {
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
        this.black = black;
    }

    /**
     *Getter for cyan
     * @return value cyan
     */
    public float getCyan() {
        return cyan;
    }
    /**
     *Getter for magenta
     * @return value magenta
     */
    public float getMagenta() {
        return magenta;
    }
    /**
     *Getter for yellow
     * @return value yellow
     */
    public float getYellow() {
        return yellow;
    }
    /**
     *Getter for black
     * @return value black
     */
    public float getBlack() {
        return black;
    }

    /**
     *Setter for cyan
     * @param cyan value of cyan
     */
    public void setCyan(float cyan) {
        this.cyan = cyan;
    }

    /**
     *Setter for magenta
     * @param magenta value of magenta
     */
    public void setMagenta(float magenta) {
        this.magenta = magenta;
    }

    /**
     *Setter for yellow
     * @param yellow value of yellow
     */
    public void setYellow(float yellow) {
        this.yellow = yellow;
    }

    /**
     *Setter for black
     * @param black value of black
     */
    public void setBlack(float black) {
        this.black = black;
    }


    /**
     * put all params in string for easy printing
     * @return a string represantion of object
     */
    @Override
    public String toString() {
        return "ColorCMYK{" +
                "cyan=" + cyan +
                ", magenta=" + magenta +
                ", yellow=" + yellow +
                ", black=" + black +
                '}';
    }

    /**
     * Additional constructor for console input
     * @param scanner uses as input
     */
    public static ColorCMYK inputColorCMYK(Scanner scanner) {
        System.out.println("Enter CMYK values (e.g., 0.0 1.0 1.0 0.0): ");
        float c = scanner.nextFloat();
        float m = scanner.nextFloat();
        float y = scanner.nextFloat();
        float k = scanner.nextFloat();

        return new ColorCMYK(c, m, y, k);
    }



    /**
     * Mean of two objects
     * @param other object of same class
     * @return object of same class with values mean of two classes
     */
    public ColorCMYK mixColors(Color other) {
        if (other instanceof ColorCMYK) {
            ColorCMYK otherCMYK = (ColorCMYK) other;
            return new ColorCMYK(
                    (this.cyan + otherCMYK.cyan)/2,
                    (this.magenta + otherCMYK.magenta)/2,
                    (this.yellow + otherCMYK.yellow)/2,
                    (this.black + otherCMYK.black)/2
            );
        }
        return new ColorCMYK(0, 0, 0, 0); // Default behavior for other color types
    }


    /**
     * Get the integer value representation of the color (override)
     * @return integer representing objects values
     */
    @Override
    public int getValueInt() {
        // Scale and convert each component to an integer value
        int intCyan = (int) this.cyan;
        int intMagenta = (int) this.magenta;
        int intYellow = (int) this.yellow;
        int intBlack = (int) this.black;

        // Combine the integer values into a single integer representation
        return (intCyan << 24) | (intMagenta << 16) | (intYellow << 8) | intBlack;
    }

    /**
     * Get the float value representation of the color (override)
     * @return float representing objects values
     */
    @Override
    public float getValueFloat() {
        // Convert each component to a float value
        float floatCyan = this.cyan / 100.0f; // Assuming cyan is in the range [0, 100]
        float floatMagenta = this.magenta / 100.0f; // Assuming magenta is in the range [0, 100]
        float floatYellow = this.yellow / 100.0f; // Assuming yellow is in the range [0, 100]
        float floatBlack = this.black / 100.0f; // Assuming black is in the range [0, 100]

        // Combine the float values into a single float representation
        return (floatCyan * 0.25f) + (floatMagenta * 0.25f) + (floatYellow * 0.25f) + (floatBlack * 0.25f);
    }


    /**
     * Method to return a formatted string representation
     * @return string
     */
    public String toStringFormatted() {
        return String.format("CMYK %f %f %f %f", getCyan(), getMagenta(), getYellow(), getBlack());
    }

    /**
     * Method to set parameters from a formatted string
     * @param formattedString string where strored type and values
     */
    public void setFromFormattedString(String formattedString) {
        // Assuming the string is in the format "CMYK C M Y K"
        String[] components = formattedString.split("\\s+");
        setCyan(Float.parseFloat(components[1]));
        setMagenta(Float.parseFloat(components[2]));
        setYellow(Float.parseFloat(components[3]));
        setBlack(Float.parseFloat(components[4]));
    }

    /**
     * Converts the CMYK color to an equivalent RGBA color.
     * @return ColorRGBA equivalent of the current CMYK color.
     */
    public ColorRGBA toColorRGBA() {
        int r = Math.round(255 * (1 - this.cyan) * (1 - this.black));
        int g = Math.round(255 * (1 - this.magenta) * (1 - this.black));
        int b = Math.round(255 * (1 - this.yellow) * (1 - this.black));
        int a = Math.round(255 * (1 - this.black));

        return new ColorRGBA(r, g, b, a);
    }

}
