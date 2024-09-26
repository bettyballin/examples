import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.formats.tiff.write.TiffOutputSet;
import java.io.File;
import java.io.IOException;

public class Temp490 {
    public static void main(String[] args) {
        Temp490 temp = new Temp490();
        try {
            temp.embedSignatureInImage("path/to/your/image.jpg");
        } catch (IOException | ImageReadException e) {
            e.printStackTrace();
        }
    }

    public void embedSignatureInImage(String filePath) throws ImageReadException, IOException {
        File imageFile = new File(filePath);

        // Read the existing metadata
        TiffOutputSet outputSet = Sanselan.getMetadata(imageFile).getExif();

        if (outputSet == null || !outputSet.hasThumbnail())
            throw new ImageReadException("No EXIF data found in image");

        // Add your signature to a custom field
        outputSet.addComment("Signature", "YourBase64EncodedSignatureHere");

        Sanselan.writeImage(imageFile, imageFile, null);
    }
}