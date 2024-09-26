import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Temp552 {
    public static void main(String[] args) {
        try {
            File imageFile = new File("path/to/your/imagefile.jpg");
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            System.out.println("Image read successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}