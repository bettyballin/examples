import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Temp1315 {
    public static void main(String[] args) {
        Temp1315 temp = new Temp1315();
        byte[] imageBytes = {}; // You can put some image bytes here to test
        boolean isValid = temp.isValidImage(imageBytes);
        System.out.println("Is valid image: " + isValid);
    }

    private boolean isValidImage(byte[] bytes) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
            BufferedImage img = ImageIO.read(bais);
            return img != null;
        } catch (IOException e) {
            // handle exception
            return false;
        }
    }
}