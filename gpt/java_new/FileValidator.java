import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileValidator {
    public static void validateFile(String inputdirectory, String inputfile) throws IOException {
        File file = new File(inputdirectory, inputfile);
        String canonicalPath = file.getCanonicalPath();
        Pattern pattern = Pattern.compile("^(abc|xyz)_\\d+\\.txt$");
        Matcher matcher = pattern.matcher(inputfile);
        
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid filename");
        }
        
        if (!canonicalPath.startsWith(new File(inputdirectory).getCanonicalPath())) {
            throw new SecurityException("Attempted directory traversal attack");
        }
    }
    
    public static void main(String[] args) {
        // Example usage
        try {
            validateFile("/my/directory", "abc_123.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}