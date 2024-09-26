import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Decryptor2 {
    private static final String ALGORITHM = "Blowfish";
    private static final String MODE = "ECB";
    private static final String PADDING = "PKCS5Padding";
    private Cipher dcipher;

    public Decryptor2(byte[] key) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);
        dcipher = Cipher.getInstance(ALGORITHM + "/" + MODE + "/" + PADDING);
        dcipher.init(Cipher.DECRYPT_MODE, skeySpec);
    }

    public String decrypt(byte[] encrypted) throws Exception {
        byte[] utf8 = dcipher.doFinal(encrypted);
        return new String(utf8, "UTF8");
    }

    public static void main(String[] args) {
        // Example usage
        try {
            String key = "your_key_here"; // replace with actual key
            String encryptedData = "encrypted_data_here"; // replace with actual encrypted data
            Decryptor2 decryptor = new Decryptor2(key.getBytes());
            String decrypted = decryptor.decrypt(encryptedData.getBytes());
            System.out.println("Decrypted Data: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}