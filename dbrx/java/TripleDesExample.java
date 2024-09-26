import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TripleDesExample {
    public static void main(String[] args) throws Exception {

        // Initialize key and IV.
        byte[] keyValue = new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x20, 0x21, 0x22, 0x23};
        byte[] ivValue = new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07};

        SecretKeySpec keySpec = new SecretKeySpec(keyValue, "DESede");
        IvParameterSpec ivSpec = new IvParameterSpec(ivValue);

        // Initialize cipher.
        Cipher desCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

        // Encrypt data
        byte[] plainData = "Hello, World!".getBytes();
        desCipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encryptedData = desCipher.doFinal(plainData);

        // Decrypt data
        desCipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decryptedData = desCipher.doFinal(encryptedData);

        // Print decrypted data for demonstration
        System.out.println(new String(decryptedData));
    }
}