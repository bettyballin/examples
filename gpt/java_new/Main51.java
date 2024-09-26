import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main51 {
    public static void main(String[] args) {
        try {
            String encrypted = "CB5E759CE5FEAFEFCC9BABBFD84DC80C0291ED4917CF1402FF03B8E12716E44C";
            String hexIv = encrypted.substring(0, 32);
            String hexCipherText = encrypted.substring(32);
            byte[] iv = new BigInteger(hexIv, 16).toByteArray();
            byte[] cipherText = new BigInteger(hexCipherText, 16).toByteArray();

            MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
            byte[] hash = sha1Digest.digest("test".getBytes());
            String sha1 = String.format("%040x", new BigInteger(1, hash));
            String keyHex = sha1.substring(0, 16);

            byte[] keyBytes = new BigInteger(keyHex, 16).toByteArray();
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
            byte[] decrypted = cipher.doFinal(cipherText);
            
            // Assuming UTF-8 encoding
            String decryptedText = new String(decrypted, "UTF-8");
            System.out.println(decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}