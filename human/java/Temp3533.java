import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipSecureFile;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String srcZipFile = "/Users/user1/Documents/ZipBomb/zbsm.zip";
        String destFolder = "/Users/user1/Documents/ZipBomb/unzipApacheLARGE/";
        main.handle(srcZipFile, destFolder);
    }

    private void handle(String srcZipFile, String destFolder) throws IOException {
        ZipSecureFile zipSecureFile = new ZipSecureFile(srcZipFile);

        Enumeration<? extends ZipArchiveEntry> entries = zipSecureFile.getEntries();
        while (entries.hasMoreElements()) {
            ZipArchiveEntry entry = entries.nextElement();

            String name = entry.getName();
            try {
                System.out.println("current file: " + name);
                try (InputStream in = zipSecureFile.getInputStream(entry)) {
                    Path path = Paths.get(destFolder, entry.getName());
                    File f = path.toFile();
                    if (entry.isDirectory()) {
                        if (!f.isDirectory() && !f.mkdirs()) {
                            throw new IOException("failed to create directory " + f);
                        }
                    } else {
                        File parent = f.getParentFile();
                        if (!parent.isDirectory() && !parent.mkdirs()) {
                            throw new IOException("failed to create directory " + parent);
                        }
                        try (OutputStream out = Files.newOutputStream(f.toPath())) {
                            org.apache.poi.util.IOUtils.copy(in, out);
                        }
                    }
                }
            } catch (Exception e) {
                throw new IOException("While handling entry " + name, e);
            }
            System.out.print("Completed Successfully!!");
        }
    }
}