import java.io.File;
import java.io.IOException;

public class FileUtils {
    private File secureOpenFile(String fileName, String directoryPath) throws IOException {
        // Normalize the directory path and make sure it's a directory
        File directory = new File(directoryPath).getCanonicalFile();
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("The provided directoryPath is not a directory.");
        }
        
        // Create a new file reference with the sanitized fileName
        File file = new File(directory, fileName).getCanonicalFile();
        
        // Check if the file's canonical path is within the directory to prevent directory traversal attacks
        if (!file.getPath().startsWith(directory.getPath())) {
            throw new SecurityException("Attempt to access file outside of the directory.");
        }
        
        return file;
    }
}