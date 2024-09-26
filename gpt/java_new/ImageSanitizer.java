import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageSanitizer {
    public byte[] sanitizeImage(byte[] inputImageBytes, String outputFormat) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputImageBytes);
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        if (bufferedImage == null) {
            throw new IOException("The image file could not be processed");
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, outputFormat, outputStream);
        return outputStream.toByteArray();
    }
}