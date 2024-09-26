import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp65 {
    public static void main(String[] args) {
        try {
            // Generate a temporary key. In practice, you would save this key.
            // See also Encrypting with DES Using a Pass Phrase.
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            keyGen.init(56); // for example
            SecretKey secretKey = keyGen.generateKey();

            // Create a DES cipher object
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");

            // Initialize the cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Example plaintext
            byte[] plaintext = "exampleplaintext".getBytes();

            // Perform encryption
            byte[] ciphertext = cipher.doFinal(plaintext);

            // Print the ciphertext
            System.out.println("Ciphertext: " + bytesToHex(ciphertext));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}