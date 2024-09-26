import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Temp2183 {
    public static void main(String[] args) {
        byte[] imageBytes = {}; // Initialize imageBytes with actual byte data

        try {
            InputStream inputStreamNew = new ByteArrayInputStream(imageBytes);
            BufferedImage bufferedImageNew = ImageIO.read(inputStreamNew);
            if (bufferedImageNew != null) {
                System.out.println("Image read successfully!");
            } else {
                System.out.println("Failed to read image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}