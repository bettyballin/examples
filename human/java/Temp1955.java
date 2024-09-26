import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Temp1955 {

    public static void main(String[] args) {
        try {
            String secretKey = "your-secret-key";
            String data = "data-to-hash";

            // Create HMAC-SHA256 key
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");

            // Create Mac instance and initialize with the secret key
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);

            // Perform final update and get the result
            byte[] result = mac.doFinal(data.getBytes());

            // Convert byte array to hex string
            String hexResult = byteArrayToHex(result);
            System.out.println(hexResult);

        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public static String byteArrayToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}