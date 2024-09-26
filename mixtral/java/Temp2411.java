import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.X509EncodedKeySpec;

public class Temp2411 {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair kp = keyGen.generateKeyPair();

            // Create X509 encoded public key
            X509EncodedKeySpec x509PublicKey = new X509EncodedKeySpec(kp.getPublic().getEncoded());

            // Write the public key to a file
            try (FileOutputStream fos = new FileOutputStream("publickey")) {
                fos.write(x509PublicKey.getEncoded());
            }

            System.out.println("Public key saved successfully.");

        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}