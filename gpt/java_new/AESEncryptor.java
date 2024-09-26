import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import org.apache.commons.codec.binary.Base64;

public class AESEncryptor {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final byte[] keyValue = new byte[] {'y', 'o', 'u', 'r', ' ', 'k', 'e', 'y', ' ', 'v', 'a', 'l', 'u', 'e'};
    private static final byte[] ivValue = new byte[] {'y', 'o', 'u', 'r', ' ', 'I', 'V', ' ', 'v', 'a', 'l', 'u', 'e'};

    public static String encrypt(String valueToEncrypt) throws Exception {
        Key key = new SecretKeySpec(keyValue, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivValue);
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encVal = c.doFinal(valueToEncrypt.getBytes());
        return Base64.encodeBase64String(encVal);
    }
}