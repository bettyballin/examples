import java.security.MessageDigest;
import java.security.PublicKey;
import java.util.Arrays;
import javax.crypto.Cipher;

public class MyClass5 {
    public boolean myCheckSignature(byte[] aMessage, byte[] aSignature, PublicKey aPK) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, aPK);
            byte[] digest1 = cipher.doFinal(aSignature);

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest2 = md.digest(aMessage);

            return Arrays.equals(digest1, digest2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}