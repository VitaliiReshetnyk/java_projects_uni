import java.util.Scanner;

/**
 * Represents child class of color system HSB.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 *
 * Bitwise operations can not be applied to float and float
 */

/**
 * ColorHSB
 * Represents HSB color, a subclass of Color.
 */
class ColorHSB extends Color {
    /**
     * HSB color components.
     */
    private float hue;
    private float saturation;
    private float brightness;

    /**
     * Constructor for ColorHSB.
     * @param hue Hue component.
     * @param saturation Saturation component.
     * @param brightness Brightness component.
     */
    public ColorHSB(float hue, float saturation, float brightness) {
        this.hue = hue;
        this.saturation = saturation;
        this.brightness = brightness;
    }

    /**
     * Getter for Hue component.
     * @return Hue component.
     */
    public float getHue() {
        return hue;
    }
    /**
     * Getter for Saturation component.
     * @return Saturation component.
     */
    public float getSaturation() {
        return saturation;
    }
    /**
     * Getter for Brightness component.
     * @return Brightness component.
     */
    public float getBrightness() {
        return brightness;
    }

    /**
     * Setter for Hue component.
     * @param hue Hue component.
     */
    public void setHue(float hue) {
        this.hue = hue;
    }
    /**
     * Setter for Saturation component.
     * @param saturation Saturation component.
     */
    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }
    /**
     * Setter for Brightness component.
     * @param brightness Brightness component.
     */
    public void setBrightness(float brightness) {
        this.brightness = brightness;
    }

    /**
     * toString method for easy printing.
     * @return String representation of the object.
     */
    @Override
    public String toString() {
        return "ColorHSB{" +
                "hue=" + hue +
                ", saturation=" + saturation +
                ", brightness=" + brightness +
                '}';
    }

    /**
     * Additional constructor for console input.
     * @param scanner Scanner object for input.
     * @return ColorHSB object created from console input.
     */
    public static ColorHSB inputColorHSB(Scanner scanner) {
        System.out.println("Enter HSB values (e.g., 0.0 1.0 1.0): ");
        float h = scanner.nextFloat();
        float s = scanner.nextFloat();
        float b = scanner.nextFloat();
        return new ColorHSB(h, s, b);
    }


    // Bitwise operations can not be applied to float and float

    /**
     * Mean to mix colors (override).
     * @param other Another color for mixing.
     * @return Resultant color after mixing.
     */
    @Override
    public ColorHSB mixColors(Color other) {
        if (other instanceof ColorHSB) {
            ColorHSB otherHSB = (ColorHSB) other;
            return new ColorHSB(
                    (this.hue + otherHSB.hue)/2,
                    (this.saturation + otherHSB.saturation)/2,
                    (this.brightness + otherHSB.brightness)/2
            );
        }
        return new ColorHSB(0, 0, 0); // Default behavior for other color types
    }

    /**
     * Get the integer value representation of the color (override)
     * @return integer representing objects values
     */
    @Override
    public int getValueInt() {
        // Convert HSB components to integers
        int intHue = (int) this.hue;
        int intSaturation = (int) this.saturation;
        int intBrightness = (int) this.brightness;

        // Combine the integer values into a single integer representation
        return (intHue << 16) | (intSaturation << 8) | intBrightness;
    }

    /**
     * Get the float value representation of the color (override)
     * @return float representing objects values
     */
    @Override
    public float getValueFloat() {
        // Convert HSB components to the range [0, 1]
        float floatHue = this.hue / 360.0f;
        float floatSaturation = this.saturation / 100.0f;
        float floatBrightness = this.brightness / 100.0f;

        // Combine the float values into a single float representation
        return (floatHue * 0.33f) + (floatSaturation * 0.33f) + (floatBrightness * 0.33f);
    }

    /**
     * Method to return a formatted string representation
     * @return string
     */
    public String toStringFormatted() {
        return String.format("HSB %f %f %f", getHue(), getSaturation(), getBrightness());
    }

    /**
     * Method to set parameters from a formatted string
     * @param formattedString string where stored type and values
     */
    public void setFromFormattedString(String formattedString) {
        // Assuming the string is in the format "HSB H S B"
        String[] components = formattedString.split("\\s+");
        setHue(Float.parseFloat(components[1]));
        setSaturation(Float.parseFloat(components[2]));
        setBrightness(Float.parseFloat(components[3]));
    }

    /**
     * Convert ColorHSB to equivalent ColorRGBA.
     * @return Equivalent ColorRGBA representation.
     */
    public ColorRGBA toColorRGBA() {
        float c = 0, m = 0, y = 0;
        float h = this.hue / 60.0f;
        float i = (float) Math.floor(h);
        float f = h - i;

        float p = this.brightness * (1.0f - this.saturation);
        float q = this.brightness * (1.0f - (this.saturation * f));
        float t = this.brightness * (1.0f - (this.saturation * (1.0f - f)));

        switch ((int) i) {
            case 0 -> { c = this.brightness; m = t; y = p; }
            case 1 -> { c = q; m = this.brightness; y = p; }
            case 2 -> { c = p; m = this.brightness; y = t; }
            case 3 -> { c = p; m = q; y = this.brightness; }
            case 4 -> { c = t; m = p; y = this.brightness; }
            case 5 -> { c = this.brightness; m = p; y = q; }
        }

        return new ColorRGBA(
                Math.round(c * 255),
                Math.round(m * 255),
                Math.round(y * 255),
                255
        );
    }
}