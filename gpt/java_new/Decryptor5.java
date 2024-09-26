import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Arrays;

public class Decryptor5 {
    private Cipher cipher;
    private Key key;

    public Decryptor5(Cipher cipher, Key key) {
        this.cipher = cipher;
        this.key = key;
    }

    public String decrypt(byte[] ivBytes, byte[] ciphertext) throws GeneralSecurityException {
        System.out.println("Using key " + Arrays.toString(key.getEncoded()) + " to decrypt");
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decodedPlaintext = cipher.doFinal(ciphertext);
        return new String(decodedPlaintext, StandardCharsets.UTF_8);
    }
}