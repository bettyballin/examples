import java.util.Base64;
import javax.crypto.Cipher;
import java.security.PublicKey;
import java.security.PrivateKey;

public class EncryptionUtil4 {

    public static String encrypt(byte[] input, PublicKey pubKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] cipherBytes = cipher.doFinal(input);
        return Base64.getEncoder().encodeToString(cipherBytes);
    }

    public static byte[] decrypt(String cipherText, PrivateKey privKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privKey);
        byte[] reCipherBytes = Base64.getDecoder().decode(cipherText);
        return cipher.doFinal(reCipherBytes);
    }
}