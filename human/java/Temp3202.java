import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Temp3202 {
    public static void main(String[] args) {
        File input = new File("input.jpg");
        File output = new File("output.png");
        try {
            BufferedImage image = ImageIO.read(input);
            if (image == null) {
                System.out.println("Image not read (decoded)");
            } else if (!ImageIO.write(image, "PNG", output)) {
                System.out.println("Image not written (could not be encoded as PNG)");
            } else {
                System.out.println("Image processed successfully");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}