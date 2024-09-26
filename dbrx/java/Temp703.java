import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Temp703 {
    public static void main(String[] args) throws Exception {

        String secretKey = "supersecretkey";
        String serverSharedKey = "supersecretkey";
        
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");

        // For generating MAC (Message Authentication Code):
        byte[] dataToSign = "data to be signed".getBytes(); // Data to be signed e.g input parameters for method calling.
        mac.init(secretKeySpec);
        byte[] macValue = mac.doFinal(dataToSign);

        // Send the encrypted data along with its corresponding HMAC value.
        // This is where you would typically send the data and MAC value.

        // At server side:
        Mac macAtServer = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpecAtServer = new SecretKeySpec(serverSharedKey.getBytes(), "HmacSHA256");

        byte[] receivedData = "data to be signed".getBytes(); // Received and decrypted data.
        byte[] hmacValueReceived = macValue; // HMAC value sent along with the encrypted data.

        // Verify MAC:
        macAtServer.init(secretKeySpecAtServer);
        byte[] macValueAtServer = macAtServer.doFinal(receivedData);

        boolean isEqual = java.util.Arrays.equals(macValueAtServer, hmacValueReceived);
        System.out.println("MAC verification: " + isEqual);
    }
}