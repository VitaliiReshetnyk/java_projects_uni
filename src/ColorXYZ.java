import java.util.Scanner;

/**
 * Represents child class of color system XYZ.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 *
 * Bitwise operations can not be applied to float and float
 */

/**
 * ColorXYZ
 * Represents XYZ color, a subclass of Color.
 */
class ColorXYZ extends Color {

    /**
     * XYZ color components.
     */
    private float x;
    private float y;
    private float z;
    /**
     * Constructor for ColorXYZ.
     * @param x X component.
     * @param y Y component.
     * @param z Z component.
     */
    public ColorXYZ(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Getter for X component.
     * @return X component.
     */
    public float getX() {
        return x;
    }
    /**
     * Getter for Y component.
     * @return Y component.
     */
    public float getY() {
        return y;
    }
    /**
     * Getter for Z component.
     * @return Z component.
     */
    public float getZ() {
        return z;
    }

    /**
     * Setter for X component.
     * @param x X component.
     */
    public void setX(float x) {
        this.x = x;
    }
    /**
     * Setter for Y component.
     * @param y Y component.
     */
    public void setY(float y) {
        this.y = y;
    }
    /**
     * Setter for Z component.
     * @param z Z component.
     */
    public void setZ(float z) {
        this.z = z;
    }
    /**
     * toString method for easy printing.
     * @return String representation of the object.
     */
    @Override
    public String toString() {
        return "ColorXYZ{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    /**
     * Additional constructor for console input.
     * @param scanner Scanner object for input.
     * @return ColorXYZ object created from console input.
     */
    public static ColorXYZ inputColorXYZ(Scanner scanner) {
        System.out.println("Enter XYZ values (e.g., 0.0 0.0 0.0): ");
        float x = scanner.nextFloat();
        float y = scanner.nextFloat();
        float z = scanner.nextFloat();

        return new ColorXYZ(x, y, z);
    }

    // Bitwise operations can not be applied to float and float

    /**
     * Mean to mix colors (override).
     * @param other Another color for mixing.
     * @return Resultant color after mixing.
     */
    @Override
    public ColorXYZ mixColors(Color other) {
        if (other instanceof ColorXYZ) {
            ColorXYZ otherXYZ = (ColorXYZ) other;
            return new ColorXYZ(
                    (this.x + otherXYZ.x)/2,
                    (this.y + otherXYZ.y)/2,
                    (this.z + otherXYZ.z)/2
            );
        }
        return new ColorXYZ(0, 0, 0); // Default behavior for other color types
    }

    /**
     * Get the integer value representation of the color (override)
     * @return integer representing objects values
     */
    @Override
    public int getValueInt() {
        // Scale and convert each component to an integer value
        int intX = (int) (x * 100);  // Scale x by 100 for example purposes
        int intY = (int) (y * 100);  // Scale y by 100 for example purposes
        int intZ = (int) (z * 100);  // Scale z by 100 for example purposes

        // Combine the integer values into a single integer representation
        return (intX << 16) | (intY << 8) | intZ;
    }

    /**
     * Get the float value representation of the color (override)
     * @return float representing objects values
     */
    @Override
    public float getValueFloat() {
        // Concatenate the XYZ components into a single float value
        // Assuming that x, y, and z are in the range [0.0, 1.0]
        int concatenatedValue = ((int)(x * 255) << 16) | ((int)(y * 255) << 8) | (int)(z * 255);

        // Convert the concatenated value to a float in the range [0.0, 1.0]
        return concatenatedValue / 16777215.0f; // 16777215 is 2^24 - 1, the maximum value of a 24-bit integer
    }

    /**
     * Method to return a formatted string representation
     * @return string
     */
    public String toStringFormatted() {
        return String.format("XYZ %f %f %f", getX(), getY(), getZ());
    }

    /**
     * Method to set parameters from a formatted string
     * @param formattedString string where stored type and values
     */
    public void setFromFormattedString(String formattedString) {
        // Assuming the string is in the format "XYZ X Y Z"
        String[] components = formattedString.split("\\s+");
        setX(Float.parseFloat(components[1]));
        setY(Float.parseFloat(components[2]));
        setZ(Float.parseFloat(components[3]));
    }

    /**
     * Placeholder getAlpha method.
     * @return Alpha component based on the average of XYZ values.
     */
    public int getAlpha() {
        float averageXYZ = (this.x + this.y + this.z) / 3.0f;
        return (int) (averageXYZ * 255);
    }

    /**
     * Convert ColorXYZ to equivalent ColorRGBA.
     * @return Equivalent ColorRGBA representation.
     */
    public ColorRGBA toColorRGBA() {
        // Assuming that XYZ values are in the range [0.0, 1.0]
        float r = getX() * 3.2406f - getY() * 1.5372f - getZ() * 0.4986f;
        float g = -getX() * 0.9689f + getY() * 1.8758f + getZ() * 0.0415f;
        float b = getX() * 0.0557f - getY() * 0.2040f + getZ() * 1.0570f;

        // Perform gamma correction
        r = (r > 0.04045f) ? (float) Math.pow((r + 0.055f) / 1.055f, 2.4f) : r / 12.92f;
        g = (g > 0.04045f) ? (float) Math.pow((g + 0.055f) / 1.055f, 2.4f) : g / 12.92f;
        b = (b > 0.04045f) ? (float) Math.pow((b + 0.055f) / 1.055f, 2.4f) : b / 12.92f;

        // Clamp values to [0, 1]
        r = Math.max(0, Math.min(r, 1));
        g = Math.max(0, Math.min(g, 1));
        b = Math.max(0, Math.min(b, 1));

        // Convert to [0, 255] range
        int red = (int) (r * 255);
        int green = (int) (g * 255);
        int blue = (int) (b * 255);

        return new ColorRGBA(red, green, blue, getAlpha());
    }

}