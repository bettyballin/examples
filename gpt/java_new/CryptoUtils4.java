import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class CryptoUtils4 {
    public static byte[] decrypt3DESCBC(byte[] keyBytes, byte[] ivBytes, byte[] dataBytes) throws Exception {
        if(keyBytes.length == 16) {
            byte[] newKey = new byte[24];
            System.arraycopy(keyBytes, 0, newKey, 0, 16);
            System.arraycopy(keyBytes, 0, newKey, 16, 8);
            keyBytes = newKey;
        }

        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "DESede");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        return cipher.doFinal(dataBytes);
    }
}