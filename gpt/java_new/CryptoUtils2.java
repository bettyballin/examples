import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

public class CryptoUtils2 {
    public static byte[] decryptByte(byte[] blahh, byte[] hexKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        byte[] key = Hex.decodeHex(new String(hexKey).toCharArray());
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(blahh);
    }
}