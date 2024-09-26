import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class Crypto {
    private Cipher ecipher;
    private Cipher dcipher;

    public Crypto(Cipher ecipher, Cipher dcipher) {
        this.ecipher = ecipher;
        this.dcipher = dcipher;
    }

    public String encrypt(String str) {
        try {
            byte[] utf8 = str.getBytes("UTF-8");
            byte[] enc = ecipher.doFinal(utf8);
            return Base64.getUrlEncoder().encodeToString(enc);
        } catch (BadPaddingException | IllegalBlockSizeException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            byte[] dec = Base64.getUrlDecoder().decode(str);
            byte[] utf8 = dcipher.doFinal(dec);
            return new String(utf8, "UTF-8");
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}