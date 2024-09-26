import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main16 {
    public static void main(String[] args) {
        String message = "[1312701386,transactioncreate,[account_code:ABC,amount_in_cents:5000,currency:USD]]";
        String privateKey = "0123456789ABCDEF0123456789ABCDEF";

        try {
            Mac hmac = Mac.getInstance("HmacSHA1");
            SecretKeySpec secretKeySpec = new SecretKeySpec(privateKey.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
            hmac.init(secretKeySpec);
            byte[] hash = hmac.doFinal(message.getBytes(StandardCharsets.US_ASCII));

            System.out.println("  Message: " + message);
            System.out.println("      Key: " + privateKey);
            System.out.println("Key bytes: " + bytesToHex(hmac.getSecretKeySpec().getEncoded()));
            System.out.println("   Result: " + bytesToHex(hash));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}