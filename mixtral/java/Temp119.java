import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Temp119 {
    public static void main(String[] args) throws IOException {
        // Load an image from the file system (replace "path_to_image.png" with the actual file path)
        BufferedImage bi = ImageIO.read(new File("path_to_image.png"));
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", baos);
        
        byte[] bytes = baos.toByteArray();
        String base64PNG = Base64.getEncoder().encodeToString(bytes);

        // Then in your HTML:
        String html = "<img src=\"data:image/png;base64," + base64PNG + "\">";
        System.out.println(html);
    }
}


To run this code, make sure you have a valid PNG image file at the specified path and replace `"path_to_image.png"` with the actual path to your image file.