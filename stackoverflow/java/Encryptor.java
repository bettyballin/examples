import java.util.Base64;
import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;

public class Encryptor {

    private Cipher ecipher;

    public Encryptor(Cipher ecipher) {
        this.ecipher = ecipher;
    }

    public String encrypt(String str) throws Exception {
        byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
        byte[] enc = ecipher.doFinal(utf8);
        return Base64.getEncoder().encodeToString(enc);
    }

    // Usage example:
    public static void main(String[] args) {
        // Cipher initialization and encryption logic
    }
}