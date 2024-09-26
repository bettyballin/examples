import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.zip.*;

public class Temp610 {
    public static void main(String[] args) {
        try {
            String name = "path/to/your/file.zip"; // You need to specify the file path here
            File file = new File(name);

            // Read input into byte array
            byte[] bytes = Files.readAllBytes(file.toPath());

            int magicNumberIndex = findZipMagicNumberPosition(bytes, 0);

            if (magicNumberIndex != -1) {
                ByteArrayInputStream bis = new ByteArrayInputStream(Arrays.copyOfRange(bytes, magicNumberIndex, bytes.length));

                // Use ZipFile or ZipInputStream to read the contents
                try (ZipInputStream zis = new ZipInputStream(bis)) {
                    ZipEntry entry;

                    while ((entry = zis.getNextEntry()) != null) {
                        System.out.println("Listing Entries in the zipfile");

                        // Process each file
                        int bytesRead;
                        byte[] buffer = new byte[1024];

                        while ((bytesRead = zis.read(buffer)) != -1) {
                            System.out.println("Processing: " + entry);

                            // Process the data
                            FileOutputStream fos = new FileOutputStream("path/to/output/" + entry.getName());
                            fos.write(buffer, 0, bytesRead);
                            fos.close();
                        }
                    }
                }
                System.out.println("Done");
            } else {
                // Handle the case when no magic number is found
                System.out.println("No magic number found in the file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int findZipMagicNumberPosition(byte[] data, int start) {
        byte[] magicNumber = {0x50, 0x4B, 0x03, 0x04}; // ZIP file magic number
        for (int i = start; i < data.length - magicNumber.length; i++) {
            boolean found = true;
            for (int j = 0; j < magicNumber.length; j++) {
                if (data[i + j] != magicNumber[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}