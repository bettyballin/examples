import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Temp54 {
    public static void main(String[] args) throws IOException {
        // Mock request object with input stream for demonstration purposes
        String mockInput = "Password123!";
        InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());

        char[] passwordChars = new char[1024];
        int bytesRead;
        // Need to use a byte array to read from InputStream
        byte[] buffer = new byte[1024];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            for (int i = 0; i < bytesRead; i++) {
                passwordChars[i] = (char) buffer[i];
            }
            // Process the chars here e.g. by hashing them with a secure hash function.
            System.out.print(passwordChars);
        }
    }
}