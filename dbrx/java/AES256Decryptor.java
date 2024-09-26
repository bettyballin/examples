import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256Decryptor {

    public static void main(String[] args) {
        byte[] encryptedData = new byte[] { /* your encrypted data here */ };
        byte[] keyBytes = new byte[] { /* your 32 bytes (256bit) secret key here */ };

        try {
            Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]); // all zero IV
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            byte[] decryptedData = aesCipher.doFinal(encryptedData);
            System.out.println(new String(decryptedData));
        } catch (Exception e) {
            System.err.println("Error while decrypting: " + e.getMessage());
        }
    }
}