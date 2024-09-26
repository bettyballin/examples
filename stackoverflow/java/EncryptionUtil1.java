import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

public class EncryptionUtil1 {

    private static Cipher cipher;
    private static Key encryptionKey;

    public static void initializeCipher() {
        // cipher = ...; // Initialize with the correct cipher instance
        // encryptionKey = ...; // Initialize with the correct encryption key
    }

    public static String decrypt(String hexEncoded) throws Exception {
        byte[] decodedBytes = hexStringToBytes(hexEncoded);
        int ivIndex = decodedBytes.length - 16;
        cipher.init(Cipher.DECRYPT_MODE, encryptionKey,
            new IvParameterSpec(decodedBytes, ivIndex, 16));
        return new String(cipher.doFinal(decodedBytes, 0, ivIndex));
    }

    private static byte[] hexStringToBytes(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                                 + Character.digit(hexString.charAt(i+1), 16));
        }
        return data;
    }
}