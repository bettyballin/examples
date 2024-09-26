import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class KeyStrengthChecker {

    public boolean isUnlimitedKeyStrength() {
        try {
            return Cipher.getMaxAllowedKeyLength("AES") >= Integer.MAX_VALUE;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}