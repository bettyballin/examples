import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.interfaces.RSAPrivateKey;

public class Temp2335 {
    public static void main(String[] args) {
        try {
            // Path to private key file
            String PRIVATE_KEY_FILE_RSA = "C:\\Users\\Adey";
            FileInputStream in = new FileInputStream(PRIVATE_KEY_FILE_RSA);
            // Passphrase - the key to decode private key
            String passphrase = "somepass";

            // Assuming PKCS8Key is a class you have access to that can handle the decryption
            // Note: This is a placeholder. PKCS8Key class must be implemented or imported from a library.
            PKCS8Key pkcs8 = new PKCS8Key(in, passphrase.toCharArray());
            byte[] decrypted = pkcs8.getDecryptedBytes();
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decrypted);
            RSAPrivateKey privKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(spec);
            
            System.out.println("Private Key: " + privKey);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}

// Placeholder class for PKCS8Key
class PKCS8Key {
    public PKCS8Key(FileInputStream in, char[] passphrase) {
        // Implement the constructor to initialize and decrypt the key
    }

    public byte[] getDecryptedBytes() {
        // Implement the method to return the decrypted bytes of the key
        return new byte[0];
    }
}