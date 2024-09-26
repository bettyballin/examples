import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class Temp42 {
    private Cipher cipher;
    private SecretKey key;

    public Temp42() throws Exception {
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        key = KeyGenerator.getInstance("AES").generateKey();
    }

    public String encrypt(String plainText) throws Exception {
        byte[] iv = new byte[cipher.getBlockSize()];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        AlgorithmParameterSpec spec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, key, spec);

        byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));

        // Combine IV and Encrypted data
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            outputStream.write(iv);
            outputStream.write(encrypted);

            byte[] cipherData = outputStream.toByteArray();

            return Base64.getEncoder().encodeToString(cipherData);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Temp42 temp42 = new Temp42();
            String encryptedText = temp42.encrypt("Hello, World!");
            System.out.println("Encrypted: " + encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}