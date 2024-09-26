import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;

public class Temp1638 {
    public static void main(String[] args) {
        // Example usage
        try {
            new Temp1638().unzip("example.zip", "outputFolder");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unzip(String srcZipFile, String destFolder) throws IOException {
        Path filePath = Paths.get(srcZipFile);
        long maxFileSizeInBytes = 1000000; // Set an upper limit on extracted files' size

        try (InputStream inputStream = Files.newInputStream(filePath);
             ZipArchiveInputStream i = new ZipArchiveInputStream(inputStream)) {

            ArchiveEntry entry;
            while ((entry = i.getNextEntry()) != null) {
                if (!i.canReadEntryData(entry)) continue;

                Path path = Paths.get(destFolder, entry.getName());
                File f = path.toFile();
                long compressedSizeInBytes = entry.getSize();

                // Check for Zip Bomb
                if (compressedSizeInBytes > maxFileSizeInBytes && !entry.isDirectory()) {
                    System.out.println("Skipping extraction of " + entry.getName() +
                            ". Compressed size (" + compressedSizeInBytes + ") exceeds the limit.");
                    continue;
                }

                if (entry.isDirectory()) {
                    // Handle directory
                    if (!f.isDirectory() && !f.mkdirs()) {
                        throw new IOException("Failed to create directory " + f);
                    }
                } else {
                    File parent = f.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }

                    // Extract file
                    try (InputStream is = i) {
                        Files.copy(is, f.toPath());
                    }
                }
            }
        }
    }
}