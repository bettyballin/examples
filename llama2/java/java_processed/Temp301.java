import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Temp301 {
    public static void main(String[] args) throws Exception {
        String toBeEncrypted = "Hello World!";
        
        // Generate secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for example 256 bits AES
        SecretKey secretKey = keyGen.generateKey();
        
        // Generate salt
        byte[] salt = new byte[8];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);

        // Use the same algorithm as OpenSSL's 'enc' command
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        AlgorithmParameters params = cipher.getParameters();
        byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
        
        byte[] cipherText = cipher.doFinal(toBeEncrypted.getBytes("UTF-8"));
        
        // Concatenate salt, IV, and ciphertext
        byte[] output = new byte[salt.length + iv.length + cipherText.length];
        System.arraycopy(salt, 0, output, 0, salt.length);
        System.arraycopy(iv, 0, output, salt.length, iv.length);
        System.arraycopy(cipherText, 0, output, salt.length + iv.length, cipherText.length);
        
        // Encode to Base64 for readability
        String encryptedText = Base64.getEncoder().encodeToString(output);
        
        System.out.println("Encrypted text: " + encryptedText);
    }
}