import java.nio.charset.StandardCharsets;

public class Temp2068 {
    public static void main(String[] args) {
        byte[] decrypted = {72, 101, 108, 108, 111};  // Example byte array
        String decryptedMessage = new String(decrypted, StandardCharsets.UTF_8);
        System.out.println(decryptedMessage);
    }
}