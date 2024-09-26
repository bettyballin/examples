import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

public class Temp1553 {
    public static void main(String[] args) throws Exception {

        KeyPairGenerator dhKpg = KeyPairGenerator.getInstance("DH");
        dhKpg.initialize(2048); // Use 2048-bit or larger DH keys

        // Generate new keypair
        KeyPair kp1 = dhKpg.generateKeyPair();

        PrivateKey privKey = kp1.getPrivate();
        PublicKey pubKey = kp1.getPublic();

        // Initialize Key Agreement
        KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
        keyAgreement.init(privKey);
        keyAgreement.doPhase(pubKey, true);

        byte[] encodedKey = keyAgreement.generateSecret();

        int aesKeyLength = 256; // AES-256
        if (encodedKey.length < aesKeyLength / Byte.SIZE) {
            throw new IllegalStateException("Not enough secret key material");
        }

        // Derive the AES key from DH shared secret
        SecretKeySpec aesKey = new SecretKeySpec(Arrays.copyOfRange(encodedKey, 0, aesKeyLength / Byte.SIZE), "AES");

        System.out.println("AES Key: " + Arrays.toString(aesKey.getEncoded()));
    }
}