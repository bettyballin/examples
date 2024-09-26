import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Temp245 {
    public static void main(String[] args) {
        try {
            String secret = "12345678901234567890";
            String movingFactor = "0";
            String hash = hmacSha1(secret, movingFactor);
            System.out.println("Hash: " + hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String hmacSha1(String key, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA1");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        mac.init(secretKeySpec);
        byte[] digest = mac.doFinal(data.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}