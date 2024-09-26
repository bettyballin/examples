import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Temp926 {

    public static void main(String[] args) {
        Temp926 temp = new Temp926();
        File file = temp.secureOpenFile("example.txt", "/path/to/directory");
        if (file != null) {
            System.out.println("File opened: " + file.getAbsolutePath());
        } else {
            System.out.println("Failed to open file.");
        }
    }

    private File secureOpenFile(String fileName, String directoryPath) {
        try {
            Path parentDir = Paths.get(directoryPath).toRealPath();
            Path filePath = parentDir.resolve(fileName);
            return filePath.toFile();
        } catch (IOException e) {
            // Handle exceptions appropriately.
            e.printStackTrace();
            return null;
        }
    }
}