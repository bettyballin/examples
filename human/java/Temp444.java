import java.io.File;
import java.io.IOException;

public class Temp444 {

    public static void main(String[] args) {
        Temp444 temp = new Temp444();
        try {
            File source = new File("source.txt");
            File destination = new File("destination.txt");
            boolean result = temp.copyFile(source, destination);
            System.out.println("Copy successful: " + result);
        } catch (CopyException e) {
            e.printStackTrace();
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

    public class CopyException extends Exception {
        public CopyException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}