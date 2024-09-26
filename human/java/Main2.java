import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("https://stackoverflow.com/questions/63185927/java-secretkey-to-string-and-rebuilding-back-to-secretkey-produces-different-de");
        // security warning: the algorithm 'RC4' or 'ARCFOUR' is unsecure and
        // should be used for educational purposes only
        // do not use this code in production
        // key generation
        KeyGenerator keygen = KeyGenerator.getInstance("RC4");
        SecretKey originalSecretKey = keygen.generateKey();
        // encryption
        byte[] plaintext = "my secret".getBytes(StandardCharsets.UTF_8);
        byte[] ciphertext = encryptRC4(plaintext, originalSecretKey);
        // decryption
        String k = Base64.getEncoder().encodeToString(originalSecretKey.getEncoded());
        byte[] decodedKey = Base64.getDecoder().decode(k);
        SecretKey rebuiltSK = new SecretKeySpec(decodedKey, "RC4");
        byte[] decryptedtext = decryptRC4(ciphertext, rebuiltSK);
        // output
        System.out.println("plaintext equals decryptedtext: " + Arrays.equals(plaintext, decryptedtext));
        System.out.println("decryptedtext: " + new String(decryptedtext));
    }

    public static byte[] encryptRC4(byte[] b, SecretKey k) throws Exception
    {
        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.ENCRYPT_MODE, k);
        byte[] encrypted = cipher.doFinal(b);
        return encrypted;
    }
    public static byte[] decryptRC4(byte[] b, SecretKey k) throws Exception
    {
        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.DECRYPT_MODE, k);
        byte[] decrypted = cipher.doFinal(b);
        return decrypted;
    }
}