import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp223 {
    public static void main(String[] args) {
        try {
            String pubKeyPath = "public_key.pem";
            String signatureBase64 = "signatureBase64"; // Replace with your actual signature base64 string
            byte[] buffer = "dataToVerify".getBytes(); // Replace with the actual data to verify

            // Read the public key from the PEM file
            String pubKeyPEM = new String(Files.readAllBytes(Paths.get(pubKeyPath)))
                    .replace("-----BEGIN PUBLIC KEY-----", "")
                    .replace("-----END PUBLIC KEY-----", "")
                    .replaceAll("\\s", "");

            byte[] pubKeyBytes = Base64.getDecoder().decode(pubKeyPEM);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(keySpec);

            // Initialize the Signature object
            Signature verify = Signature.getInstance("SHA256withRSA");
            verify.initVerify(pubKey);

            // Update the Signature object with the data
            verify.update(buffer);

            // Verify the signature
            boolean isValid = verify.verify(Base64.getDecoder().decode(signatureBase64));

            System.out.println("Signature valid: " + isValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}