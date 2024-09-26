import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSecurity {
    public static void main(String[] args) {
        String userInput = "../../etc/passwd";
        
        // Normalize the path to remove any unwanted sequences (like ../)
        Path normalizedPath = Paths.get(userInput).normalize();
        
        System.out.println("Normalized path: " + normalizedPath);
        
        // Implement a whitelist approach by checking if the file is within an allowed directory
        String[] allowedDirectories = {"./", "./home/", "./var/www/"}; 
        boolean isInAllowedDirectory = false;
        
        for (String dir : allowedDirectories) {
            Path rootPath = Paths.get(dir).normalize();
            
            // Check if the normalized path starts with one of the whitelisted directories
            if (normalizedPath.startsWith(rootPath)) {
                isInAllowedDirectory = true;
                
                break;  // Exit early since we found a match
            }
        }

        System.out.println("Is in allowed directory: " + isInAllowedDirectory);
    }
}