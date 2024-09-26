import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.zip.*;

public class HiddenZipExtractor {
    public static void main(String[] args) {
        String imagePath = "hidden.jpg";
        String outputPath = "extracted.zip";

        try {
            File imageFile = new File(imagePath);
            FileInputStream fis = new FileInputStream(imageFile);
            byte[] buffer = new byte[(int) imageFile.length()];
            fis.read(buffer);
            fis.close();

            int startOfZip = -1;
            for (int i = 0; i < buffer.length - 3; i++) {
                if (buffer[i] == 0x50 && buffer[i + 1] == 0x4B && buffer[i + 2] == 0x03 && buffer[i + 3] == 0x04) {
                    startOfZip = i;
                    break;
                }
            }

            if (startOfZip >= 0) {
                FileOutputStream fos = new FileOutputStream(outputPath);
                fos.write(buffer, startOfZip, buffer.length - startOfZip);
                fos.close();
                System.out.println("Zip file extracted!");
            } else {
                System.out.println("Zip file not found in image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}