import java.io.File;
import java.io.IOException;

public class SecureFileAccess {
    public static void main(String[] args) {
        try {
            String directoryName = "/safe/directory";
            String filePath = "../other/path";

            File file = new File(directoryName, filePath).getCanonicalFile();
            if (!file.getPath().startsWith(new File(directoryName).getCanonicalPath())) {
                throw new SecurityException("Attempted directory traversal attack");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}