import java.net.URLDecoder;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

public class Decryptor {
    private Cipher dcipher;

    public Decryptor(Cipher dcipher) {
        this.dcipher = dcipher;
    }

    public String decrypt(String value) throws Exception {
        String decryptedValue = URLDecoder.decode(value, "UTF-8");
        byte[] dec = new Base64().decode(decryptedValue.getBytes());
        byte[] utf8 = dcipher.doFinal(dec);
        return new String(utf8, "UTF-8");
    }
}