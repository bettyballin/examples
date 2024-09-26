import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp393 {
    public static void main(String[] args) {
        try {
            // Generate a temporary key. In practice, you would save this key.
            // See also Encrypting with DES Using a Pass Phrase.
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(128);
            SecretKey secretKey = keygen.generateKey();
            byte[] raw = secretKey.getEncoded();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

            // Instantiate the cipher
            Cipher cipher = Cipher.getInstance("AES");

            String originalText = "test text 123";
            System.out.println("==JAVA==");
            System.out.println("plain:   " + originalText);

            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(originalText.getBytes());
            System.out.print("cipher:  ");
            for (byte b : encrypted) {
                System.out.print(b + " ");
            }
            System.out.println();

            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] decrypted = cipher.doFinal(encrypted);
            String decryptedText = new String(decrypted);
            System.out.println("decrypt: " + decryptedText);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}