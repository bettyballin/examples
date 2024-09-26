import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Temp284 {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("encryptedfile.txt")) {
            byte[] keyBytes = new byte[32];
            byte[] ivBytes = new byte[16];

            try {
                is.read(keyBytes, 0, 32);
                is.read(ivBytes, 0, 16);
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringBuilder keyHex = new StringBuilder();
            StringBuilder ivHex = new StringBuilder();

            for (byte b : keyBytes) {
                keyHex.append(String.format("%02x", b));
            }

            for (byte b : ivBytes) {
                ivHex.append(String.format("%02x", b));
            }

            System.out.println("Key (Hex): " + keyHex.toString());
            System.out.println("IV (Hex): " + ivHex.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}