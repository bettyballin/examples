import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.util.Base64;

public class Temp1655 {
    public static void main(String[] args) {
        try {
            String secretKey = "very-secret-key";
            String id1 = "1001";
            String id2 = "2002";
            String id3 = "3003";
            
            // Convert the secret key and IDs into byte arrays
            byte[] bufferKey = secretKey.getBytes(StandardCharsets.UTF_8);
            byte[] bufferId1 = id1.getBytes(StandardCharsets.UTF_8);
            byte[] bufferId2 = id2.getBytes(StandardCharsets.UTF_8);
            byte[] bufferId3 = id3.getBytes(StandardCharsets.UTF_8);
            
            // Concatenate the IDs into a single byte array
            byte[] concatenatedIds = new byte[bufferId1.length + bufferId2.length + bufferId3.length];
            System.arraycopy(bufferId1, 0, concatenatedIds, 0, bufferId1.length);
            System.arraycopy(bufferId2, 0, concatenatedIds, bufferId1.length, bufferId2.length);
            System.arraycopy(bufferId3, 0, concatenatedIds, bufferId1.length + bufferId2.length, bufferId3.length);
            
            // Create an HMAC object with SHA256 algorithm and secret key
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bufferKey, "HmacSHA256");
            mac.init(secretKeySpec);
            
            // Update the HMAC content using the concatenation of ID byte arrays
            mac.update(concatenatedIds);
            
            // Generate the final digest as a base64 string then replace '.' characters if any.
            String token = Base64.getEncoder().encodeToString(mac.doFinal()).replace(".", "");
            
            System.out.println(token);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No such algorithm: " + e.getMessage());
        } catch (InvalidKeyException e) {
            System.err.println("Invalid key: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}