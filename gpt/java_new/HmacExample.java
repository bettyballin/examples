import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class HmacExample {
    public static void main(String[] args) {
        try {
            String password = "your_password_here";
            byte[] keyBytes = password.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "HmacSHA1");

            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);

            String message = "The message to be hashed.";
            byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
            byte[] result = mac.doFinal(messageBytes);

            // Convert the result to a hex string (not necessary, just for demonstration)
            StringBuilder hexString = new StringBuilder();
            for (byte b : result) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            System.out.println("HMAC: " + hexString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}