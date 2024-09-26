import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Temp3201 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Temp3201 <input_image> <output_image>");
            return;
        }

        String inputPath = args[0];
        String outputPath = args[1];

        try {
            File input = new File(inputPath);
            File output = new File(outputPath);

            BufferedImage image = ImageIO.read(input);
            if (image == null) {
                System.out.println("The specified input file is not a valid image.");
                return;
            }

            ImageIO.write(image, "PNG", output);
            System.out.println("Image has been successfully written to " + outputPath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}