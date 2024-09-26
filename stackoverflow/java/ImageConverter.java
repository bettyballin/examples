import javax.imageio.ImageIO;
import java.io.File;

public class ImageConverter {
    public static void main(String[] args) {
        File input = new File("input.jpg"); // change to your input file path
        File output = new File("output.png"); // change to your output file path

        try {
            ImageIO.write(ImageIO.read(input), "png", output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}