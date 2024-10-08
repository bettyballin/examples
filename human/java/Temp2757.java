import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

class RemoteEditFileContends {

  /**
   * Edits the text file in zip.
   *
   * @param zipFilePathInstance
   *          the zip file path instance
   * @throws IOException
   *           Signals that an I/O exception has occurred.
   */
  public static void editTextFileInZip(String zipFilePathInstance) throws IOException {
    Path pathInstance = Paths.get(zipFilePathInstance);
    try (FileSystem fileSystemIns = FileSystems.newFileSystem(pathInstance, (ClassLoader) null)) {
      Path pathSourceInstance = fileSystemIns.getPath("/abc.txt");
      Path tempCopyIns = generateTempFile(fileSystemIns);
      Files.move(pathSourceInstance, tempCopyIns);
      streamCopy(tempCopyIns, pathSourceInstance);
      Files.delete(tempCopyIns);
    }
  }

  /**
   * Generate temp file.
   *
   * @param fileSystemIns
   *          the file system ins
   * @return the path
   * @throws IOException
   *           Signals that an I/O exception has occurred.
   */
  public static Path generateTempFile(FileSystem fileSystemIns) throws IOException {
    Path tempCopyIns = fileSystemIns.getPath("/___abc___.txt");
    if (Files.exists(tempCopyIns)) {
      throw new IOException("temp file exists, generate another name");
    }
    return tempCopyIns;
  }

  /**
   * Stream copy.
   *
   * @param sourecInstance
   *          the src
   * @param destinationInstance
   *          the dst
   * @throws IOException
   *           Signals that an I/O exception has occurred.
   */
  public static void streamCopy(Path sourecInstance, Path destinationInstance) throws IOException {
    try (
        BufferedReader bufferInstance = new BufferedReader(new InputStreamReader(Files.newInputStream(sourecInstance)));
        BufferedWriter writerInstance = new BufferedWriter(
            new OutputStreamWriter(Files.newOutputStream(destinationInstance)))) {
      String currentLine = null;
      while ((currentLine = bufferInstance.readLine()) != null) {
        currentLine = currentLine.replace("key1=value1", "key1=value2");
        writerInstance.write(currentLine);
        writerInstance.newLine();
      }
    }
  }

  public static void main(String[] args) throws IOException {
    // Create a test zip file with abc.txt inside for demonstration
    createTestZipFile("test.zip");

    editTextFileInZip("test.zip");

    // Print the contents of the edited abc.txt from the zip
    printContentsOfZipFile("test.zip", "abc.txt");
  }

  private static void createTestZipFile(String zipFilePath) throws IOException {
    try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
      zos.putNextEntry(new ZipEntry("abc.txt"));
      zos.write("key1=value1\nanother line".getBytes());
      zos.closeEntry();
    }
  }

  private static void printContentsOfZipFile(String zipFilePath, String fileName) throws IOException {
    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
      ZipEntry entry;
      while ((entry = zis.getNextEntry()) != null) {
        if (entry.getName().equals(fileName)) {
          BufferedReader reader = new BufferedReader(new InputStreamReader(zis));
          String line;
          while ((line = reader.readLine()) != null) {
            System.out.println(line);
          }
          zis.closeEntry();
          break;
        }
      }
    }
  }
}