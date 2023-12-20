import javax.swing.*;
import java.awt.*;

/**
 * Represents class to visually show Mask.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 */
public class MaskVisualizer extends JFrame {
    private Mask mask;
    int cellSize = 20; // Adjust the cell size as needed
    /**
     * Constructs an MaskVisualizer with the specified Image.
     * @param mask Mask to visualize.
     */
    public MaskVisualizer(Mask mask) {
        this.mask = mask;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((mask.getHeight()+2)*cellSize, (mask.getWidth()+2)*cellSize);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    /**
     * visual method to draw a picture
     * @param g Mask to visualize.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < mask.getWidth(); i++) {
            for (int j = 0; j < mask.getHeight(); j++) {
                int value = mask.getPixel(i, j);

                // Normalize the value to be in the range [0, 255]
                double normalizedValue = value / 255.0;

                // Map the normalized value to an intensity level in the range [0, 255]
                int intensity = (int) (normalizedValue * 255);

                g.setColor(new java.awt.Color(intensity, intensity, intensity));
                g.fillRect((j+1) * cellSize, (i+1) * cellSize+cellSize/2, cellSize, cellSize);
            }
        }
    }

/*
    public static void main(String[] args) {
        Mask mask = new Mask(5, 100);

        // Set some pixel values for demonstration
        mask.setPixel(1, 2, 100);
        mask.setPixel(3, 90, 200);

        SwingUtilities.invokeLater(() -> new MaskVisualizer(mask));
    }*/

}
