import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Temp54 {
    public static void main(String[] args) {
        try {
            // Get the KeyStore instance
            KeyStore ks = KeyStore.getInstance("JKS");

            // Load the keystore (you would generally provide the keystore file and password here)
            ks.load(null, null);

            // Dummy certificate and key for demonstration purposes
            // In real scenarios, you would load the actual keystore and get the certificate
            Certificate cert = ks.getCertificate("my-certificate");
            if (cert == null) {
                System.out.println("Certificate not found!");
                return;
            }

            // Get the public key
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(cert.getPublicKey().getEncoded());

            // Use the public key to encrypt data
            // Note: AES/ECB/NoPadding requires a 16-byte key for AES. Public key encryption is usually done with RSA.
            // Here, we are using a dummy 16-byte AES key for demonstration purposes.
            byte[] aesKeyBytes = new byte[16]; // This should be replaced with a proper 16-byte key
            SecretKeySpec secretKeySpec = new SecretKeySpec(aesKeyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedData = cipher.doFinal("Hello World!".getBytes());

            System.out.println("Encrypted data: " + java.util.Arrays.toString(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}