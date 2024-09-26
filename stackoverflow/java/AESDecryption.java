import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertEquals;

public class AESDecryption {
    public static void main(String[] args) throws Exception {
        // Assuming AESCipher is already initialized with the correct key and mode
        Cipher AESCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[] { /* key bytes here */ };
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        AESCipher.init(Cipher.DECRYPT_MODE, keySpec); // Assuming IV is set or not needed

        // encrypted1, encrypted2, and expected need to be defined with proper values
        byte[] encrypted1 = new byte[] { /* encrypted data here */ };
        byte[] encrypted2 = new byte[] { /* encrypted data here */ };
        String expected = "expected plaintext string";

        ByteArrayOutputStream fullPlaintextStream = new ByteArrayOutputStream();

        byte[] dec1 = AESCipher.update(encrypted1);
        fullPlaintextStream.write(dec1);

        byte[] dec2 = AESCipher.update(encrypted2);
        fullPlaintextStream.write(dec2);

        byte[] dec3 = AESCipher.doFinal();
        fullPlaintextStream.write(dec3);

        String r = new String(fullPlaintextStream.toByteArray());
        assertEquals(expected, r);
    }
}