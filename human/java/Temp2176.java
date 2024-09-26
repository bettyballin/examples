import java.util.Base64;

public class Temp2176 {
    public static void main(String[] args) {
        String message = "Hello, World!";
        byte[] encryptedMessage = encryptMessage(message);
        System.out.println(Base64.getEncoder().encodeToString(encryptedMessage));
    }

    private static byte[] encryptMessage(String message) {
        // Simple encryption logic (for demonstration purposes only)
        byte[] bytes = message.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] += 1; // Simple Caesar cipher shift
        }
        return bytes;
    }
}