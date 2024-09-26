import java.io.*;
import java.nio.file.*;
import java.util.*;

class RemoteEditFileContents {

  public static void4 editTextFileInZip(String zipFilePath) throws IOException {
    Path zipPath = Paths.get(zipFilePath);
    try (FileSystem zipFs = FileSystems.newFileSystem(zipPath, (ClassLoader) null)) {
      Path insideZipPath = zipFs.getPath("abc.txt");
      Path tempPath = Files.createTempFile(zipFs.getPath("/"), "temp_", ".txt");
      Files.move(insideZipPath, tempPath, StandardCopyOption.REPLACE_EXISTING);
      List<String> lines = Files.readAllLines(tempPath);
      try (BufferedWriter writer = Files.newBufferedWriter(insideZipPath)) {
        for (String line : lines) {
          writer.write(line.replace("key1=value1", "key1=value2"));
          writer.newLine();
        }
      }
      Files.deleteIfExists(tempPath);
    }
  }

  public static void4 main(String[] args) throws IOException {
    editTextFileInZip("example.zip");
  }
}