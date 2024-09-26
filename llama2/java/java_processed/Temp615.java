import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp615 {
    public static void main(String[] args) {
        try {
            byte[] id1 = Base64.getDecoder().decode("MTAwMQ==");
            byte[] id2 = Base64.getDecoder().decode("MjAwMg==");
            byte[] id3 = Base64.getDecoder().decode("MzAwMw==");

            // Create a buffer from the secret key
            byte[] secretKeyBuffer = Base64.getDecoder().decode("dmVyeS1zZWNyZXQta2V5");

            // Use Mac to generate the HMAC object
            Mac hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBuffer, "HmacSHA256");
            hmac.init(secretKeySpec);

            // Concatenate the IDs and get the digest
            hmac.update(id1);
            hmac.update(id2);
            hmac.update(id3);
            byte[] tokenBytes = hmac.doFinal();

            String token = Base64.getEncoder().encodeToString(tokenBytes).replace(".", "");
            System.out.println("Token: " + token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}