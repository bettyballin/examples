import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.spec.IvParameterSpec;

public class Temp1316 {
    public static void main(String[] args) {
        try {
            Cipher des = Cipher.getInstance("DES/CBC/PKCS5Padding");
            SecretKey key = KeyGenerator.getInstance("DES").generateKey();
            IvParameterSpec iv = des.getParameters().getParameterSpec(IvParameterSpec.class);
            des.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] ivBytes = iv.getIV(); // get the IV used for encryption
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}