import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Temp553 {

    public static void main(String[] args) {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        
        // Simulate some image data
        for(int y = 0; y < 100; y++) {
            for(int x = 0; x < 100; x++) {
                bufferedImage.setRGB(x, y, (x * y) % 256);
            }
        }

        RenderedImage renderedImage = bufferedImage;
        PbmImage pbmImage = new PbmImage(renderedImage);
        byte[] pbmData = pbmImage.getData();
        
        // Print the PBM data length for demonstration
        System.out.println("PBM Data Length: " + pbmData.length);
    }
}

class PbmImage {
    private RenderedImage renderedImage;
    
    public PbmImage(RenderedImage renderedImage) {
        this.renderedImage = renderedImage;
    }
    
    public byte[] getData() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(renderedImage, "pbm", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
}