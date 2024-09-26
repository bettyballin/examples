import java.nio.file.*;
import java.io.*;
import javax.xml.bind.DatatypeConverter;

public class Temp2010 {
    public static void main(String[] args) {
        // You can call the isValidImage method here for testing
        Path imagePath = Paths.get("path_to_image_file");
        Temp2010 temp = new Temp2010();
        boolean isValid = temp.isValidImage(imagePath);
        System.out.println("Is valid image: " + isValid);
    }

    public boolean isValidImage(Path path) {
        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] headerBytes = new byte[4];

            // Read the first 4 bytes of the file
            int readCount = inputStream.read(headerBytes);

            if (readCount != -1) {
                String magicNumberHexString = DatatypeConverter.printHexBinary(headerBytes).toLowerCase();

                switch (magicNumberHexString) {
                    case "ffd8ffe0":
                        return true; // JPEG

                    case "47494638":
                        if ((inputStream.read() & 255) == 'a')
                            return true; // GIF

                    default:
                        String mimeType = Files.probeContentType(path);

                        switch (mimeType != null ? mimeType : "") {
                            case "image/jpeg":
                                if ("ffd8".equalsIgnoreCase(magicNumberHexString))
                                    return true; // JPEG
                            case "image/png":
                                if ("89504e47".equalsIgnoreCase(magicNumberHexString))
                                    return true; // PNG
                            case "image/gif":
                                if ("47494638".equalsIgnoreCase(magicNumberHexString))
                                    return true; // GIF
                        }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}