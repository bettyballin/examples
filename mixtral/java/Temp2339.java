import javax.crypto.Cipher;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;

public class Temp2339 {
    private static final Charset ENCODING = StandardCharsets.UTF_8;

    public static void main(String[] args) throws Exception {
        // Generate a key pair for demonstration purposes
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey decryptingKey = keyPair.getPrivate();

        // Replace with your actual encrypted data
        byte[] scrambledBytes = new byte[]{ /* Your encrypted data here */ };

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, decryptingKey);

        // Decryption
        byte[] plainBytes = cipher.doFinal(scrambledBytes);

        String originalText = new String(plainBytes, ENCODING);

        System.out.println("Decrypted text: " + originalText);
    }
}