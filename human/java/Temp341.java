import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Temp341 {
    public static void main(String[] args) {
        String message = "[1312701386,transactioncreate,[account_code:ABC,amount_in_cents:5000,currency:USD]]";
        String privateKey = "0123456789ABCDEF0123456789ABCDEF";

        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] hashedKey = sha1.digest(privateKey.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec signingKey = new SecretKeySpec(hashedKey, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] hash = mac.doFinal(message.getBytes(StandardCharsets.US_ASCII));

            System.out.println("  Message: " + message);
            System.out.println("      Key: " + privateKey + "\n");
            System.out.println("Key bytes: " + bytesToHex(hashedKey));
            System.out.println("   Result: " + bytesToHex(hash));
        } catch (NoSuchAlgorithmException | java.security.InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}