import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileToByteArray {
    public static void main(String[] args) {
        File file = new File("path/to/your/file");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] filecontent = new byte[(int) file.length()];
            fis.read(filecontent);

            byte[] positiveFileContent = new byte[filecontent.length + 1];
            System.arraycopy(filecontent, 0, positiveFileContent, 1, filecontent.length);
            
            // Now positiveFileContent can be used where a positive BigInteger is needed
            // Example: BigInteger number = new BigInteger(positiveFileContent);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}