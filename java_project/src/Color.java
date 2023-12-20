/**
 * Represents parent class of color systems.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 */
/**
 * Color
 * Represents color
 */
public class Color {
    /**
     * Default constructor for the base class.
     */

    public Color() {
    }

    /**
     * Bitwise intersection of two colors.
     * @param other Another color for intersection.
     * @return Resultant color after intersection.
     */
    public Color bitwiseIntersection(Color other) {
        return new Color();
    }

    /**
     * Bitwise union of two colors.
     * @param other Another color for union.
     * @return Resultant color after union.
     */
    public Color bitwiseUnion(Color other) {
        return new Color();
    }

    /**
     * Bitwise XOR of two colors.
     * @param other Another color for XOR operation.
     * @return Resultant color after XOR operation.
     */
    public Color bitwiseXOR(Color other) {
        return new Color();
    }

    /**
     * Get the integer value representation of the color.
     * @return Integer representation of the color.
     */
    public int getValueInt() {
        return 0;
    }

    /**
     * Get the float value representation of the color.
     * @return Float representation of the color.
     */
    public float getValueFloat() {
        return 0.0f;
    }

    /**
     * Mix two colors by taking the mean of each component.
     * @param other Another color for mixing.
     * @return Resultant color after mixing.
     */
    public Color mixColors(Color other) {
        return new Color();
    }
}
