import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.interfaces.BCECPrivateKey;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp2873 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            // Example private key in Base64 format (replace with your actual key)
            String privateKeyBase64 = "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgJ8FQX9e8mX+J6BzFbA4hOM3H5z+VQ1Mw6wB9pMp1sD+hRANCAAQ9l8J2Kp3C5Kp4z5o7pP6k4O1ZJ0vM7rY0Q2p43v7f6M6Cf+o5Q0HqgU1ci8J+LZ9Z8cOjMi2FvP3Y0nQqXjZp";

            // Decode the Base64 encoded key
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);

            // Generate the private key
            KeyFactory keyFactory = KeyFactory.getInstance("EC", "BC");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            // Cast to BCECPrivateKey
            BCECPrivateKey privateKey1 = (BCECPrivateKey) privateKey;
            byte[] bigIntPk = privateKey1.getS().toByteArray();

            // Print the byte array
            for (byte b : bigIntPk) {
                System.out.printf("%02X ", b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}