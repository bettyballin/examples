import java.io.InputStream;
import java.io.IOException;

public class BufferReader {
    public static void main(String[] args) {
        byte[] buffer = new byte[8192]; // Use a larger buffer size for better performance
        InputStream inputStream = null; // Replace with your actual InputStream

        try {
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                // Process the bytes read, which are stored in 'buffer' from index 0 to bytesRead-1
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}