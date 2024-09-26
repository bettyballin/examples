import java.io.InputStream;
import java.util.Scanner;

public class Temp233 {
    public static void main(String[] args) {
        try {
            // Dummy cipher class to simulate dcipher object
            Cipher dcipher = new Cipher();
            InputStream dec = System.in; // Dummy input stream, replace with actual encrypted stream

            InputStream decryptStream = dcipher.getDecryptingInputStream(dec);
            String decodedStr = new Scanner(decryptStream).useDelimiter("\\A").next();

            System.out.println("Decoded String: " + decodedStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Dummy cipher class to simulate decrypting stream
class Cipher {
    public InputStream getDecryptingInputStream(InputStream inputStream) {
        // Dummy implementation, replace with actual decryption logic
        return inputStream;
    }
}