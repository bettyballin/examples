import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp252 {
    public static void main(String[] args) throws Exception {
        // Read the public key from a file
        String publicKeyPem = new String(Files.readAllBytes(Paths.get("public_key.pem")));
        
        // Process the public key string
        publicKeyPem = publicKeyPem.replaceAll("\\s+", "").replaceAll("-----BEGIN(.*?)-----END(.*?)-----", "");
        
        // Decode the base64 encoded string to get the key bytes
        byte[] pubEncoded = Base64.getDecoder().decode(publicKeyPem);
        
        // Create X509EncodedKeySpec with the key bytes
        X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubEncoded);
        
        // Generate the public key
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pubKey = kf.generatePublic(pubSpec);
        
        // Output the public key to check if it's correctly generated
        System.out.println(pubKey);
    }
}