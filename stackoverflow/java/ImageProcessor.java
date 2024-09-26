import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {

    public static void main(String[] args) {
        File input = new File("input.jpg"); // Example file input
        File output = new File("output.png"); // Example file output

        try {
            BufferedImage image = ImageIO.read(input);
            if (image == null) {
                // TODO: Handle image not read (decoded)
            } else {
                if (!ImageIO.write(image, "PNG", output)) {
                    // TODO: Handle image not written (could not be encoded as PNG)
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}