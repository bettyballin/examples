import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp877 {

    public static void main(String[] args) {
        // Simulating a Bitmap object (not real code, for demonstration purposes)
        // In real usage, you should use an actual Bitmap object from an image.
        byte[] dummyBitmapData = new byte[1024];
        java.util.Arrays.fill(dummyBitmapData, (byte) 1); // fill with dummy data
        ByteBuffer bb = ByteBuffer.allocate(dummyBitmapData.length);
        bb.put(dummyBitmapData);

        // Encrypt the bitmap data
        byte[] key = generateKey();
        byte[] encryptedData = Security.encrypt(key, dummyBitmapData);

        // Decrypt the data (for demonstration purposes)
        byte[] decryptedData = Security.decrypt(key, encryptedData);

        // Print encrypted and decrypted data for verification
        System.out.println("Encrypted Data: " + java.util.Arrays.toString(encryptedData));
        System.out.println("Decrypted Data: " + java.util.Arrays.toString(decryptedData));
    }

    private static byte[] generateKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            return secretKey.getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("Error generating key", e);
        }
    }

    static class Security {

        public static byte[] encrypt(byte[] key, byte[] data) {
            try {
                SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                return cipher.doFinal(data);
            } catch (Exception e) {
                throw new RuntimeException("Error during encryption", e);
            }
        }

        public static byte[] decrypt(byte[] key, byte[] data) {
            try {
                SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                return cipher.doFinal(data);
            } catch (Exception e) {
                throw new RuntimeException("Error during decryption", e);
            }
        }
    }
}