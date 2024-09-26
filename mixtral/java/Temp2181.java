import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Temp2181 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = Temp2181.class.getResourceAsStream("/path/to/image.jpg"); // Provide the correct path to your image
            if (inputStream == null) {
                throw new IOException("Image not found");
            }
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            System.out.println("Image successfully read");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}