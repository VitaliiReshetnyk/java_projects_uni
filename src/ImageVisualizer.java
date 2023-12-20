import javax.swing.*;
import java.awt.*;

/**
 * Represents class to visually show Image.
 * 20.12.2023
 *
 * @author Vitalii Reshetnyk
 */
public class ImageVisualizer extends JFrame {
    private Image image;
    int cellSize = 20; // Adjust the cell size as needed
    /**
     * Constructs an ImageVisualizer with the specified Image.
     * @param image Image to visualize.
     */
    public ImageVisualizer(Image image) {
        this.image = image;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((image.getHeight()+2)*cellSize, (image.getWidth()+2)*cellSize);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    /**
     * visual method to draw a picture
     * @param g Image to visualize.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                ColorRGBA color = image.getPixel(i, j);
                g.setColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()));
                g.fillRect((j+1) * cellSize, (i+1) * cellSize+cellSize/2, cellSize, cellSize);
            }
        }
    }
/*
    public static void main(String[] args) {
        Image image = new Image(5, 5);

        // Set some pixel values for demonstration
        image.setPixel(0, 0, new ColorRGBA(255, 0, 0, 255)); // Red
        image.setPixel(4, 4, new ColorRGBA(0, 0, 255, 255)); // Blue

        SwingUtilities.invokeLater(() -> new ImageVisualizer(image));
    }*/
}
