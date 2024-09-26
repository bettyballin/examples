import java.io.File;
import java.io.IOException;

public class FileCopyUtil {

    public static class CopyException extends Exception {
        public CopyException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public boolean copyFile(File source, File destination) throws CopyException {
        try {
            // lots of code
            return true;
        } catch (IOException e) {
            throw new CopyException("File copy failed", e);
        }
    }
}