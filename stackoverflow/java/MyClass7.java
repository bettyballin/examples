import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MyClass7 {
    public static void main(String[] args) {
        try {
            String secretKey = "secret-key";
            String algorithm = "HmacSHA256";
            String data = "data";

            // Initialize Mac instance
            Mac mac = Mac.getInstance(algorithm);
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
            mac.init(keySpec);

            // Perform HMAC on data
            byte[] result = mac.doFinal(data.getBytes());

            // Convert byte array to hex string
            String hexResult = byteArrayToHex(result);
            System.out.println(hexResult);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    private static String byteArrayToHex(byte[] byteArray) {
        StringBuilder hex = new StringBuilder(byteArray.length * 2);
        for (byte b : byteArray) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}