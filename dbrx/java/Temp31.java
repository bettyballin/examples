import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class Temp31 {
    public static void main(String[] args) {
        try {
            String data = "Hello, World!";
            
            // Generate a secret key for HMAC-SHA256
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            keyGen.init(256); // initialize key size
            SecretKey secretKey = keyGen.generateKey();
            
            // Calculate HMAC
            String hmac = calculateHMAC(data, secretKey);
            System.out.println("HMAC: " + hmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public static String calculateHMAC(String data, SecretKey secret) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secret);
        byte[] hmacData = mac.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(hmacData);
    }
}