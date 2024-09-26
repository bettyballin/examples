import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

public class Main100 {

    public static void main(String[] args) throws IOException {
        Main100 main = new Main100();
        String srcZipFile = "/Users/user1/Documents/ZipBomb/zbsm.zip";
        String destFolder = "/Users/user1/Documents/ZipBomb/unzipApacheLARGE/";
        main.handle(srcZipFile, destFolder);
    }

    private void handle(String srcZipFile, String destFolder) throws IOException {
        try (ZipFile zipFile = new ZipFile(srcZipFile)) {
            Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();
            while (entries.hasMoreElements()) {
                ZipArchiveEntry entry = entries.nextElement();
                String name = entry.getName();
                System.out.println("current file: " + name);
                Path path = Paths.get(destFolder, name);
                File f = path.toFile();
                if(entry.isDirectory()) {
                    if (!f.isDirectory() && !f.mkdirs()) {
                        throw new IOException("failed to create directory " + f);
                    }
                } else {
                    File parent = f.getParentFile();
                    if(!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("failed to create directory " + parent);
                    }
                    try (InputStream in = zipFile.getInputStream(entry)) {
                        Files.copy(in, f.toPath());
                    }
                }
            }
        }
        System.out.print("Completed Successfully!!");
    }
}