import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoHelper1 {
    private static final String AES_TOKEN = "my_very_secret_token";
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String CHARSET_NAME = "UTF-8";

    public String decrypt(String encrypted) throws Exception {
        byte[] decrypted = Base64.getDecoder().decode(encrypted);
        return new String(aesDecrypt(decrypted), CHARSET_NAME);
    }

    private byte[] aesDecrypt(byte[] messageWithIv) throws Exception {
        if (messageWithIv.length < 16) {
            throw new IllegalArgumentException("Invalid messageWithIv, too short");
        }
        byte[] iv = Arrays.copyOfRange(messageWithIv, 0, 16);
        byte[] message = Arrays.copyOfRange(messageWithIv, 16, messageWithIv.length);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(AES_TOKEN.getBytes(CHARSET_NAME), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        return cipher.doFinal(message);
    }
}