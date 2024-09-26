import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

class AES {
    public static String encrypt(String input, String password) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParams = new IvParameterSpec(salt);

        cipher.init(Cipher.ENCRYPT_MODE, secret, ivParams);
        
        byte[] encrypted = cipher.doFinal(input.getBytes("UTF-8"));
        
        byte[] encryptedWithSalt = new byte[salt.length + encrypted.length];
        System.arraycopy(salt, 0, encryptedWithSalt, 0, salt.length);
        System.arraycopy(encrypted, 0, encryptedWithSalt, salt.length, encrypted.length);
        
        return Base64.getEncoder().encodeToString(encryptedWithSalt);
    }

    public static void main(String[] args) {
        try {
            String encrypted = encrypt("Hello World", "password123");
            System.out.println("Encrypted text: " + encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}