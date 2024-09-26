import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp1299 {
    public static void main(String[] args) {
        try {
            byte[] key = "1234567890123456".getBytes(); // Example key, use a proper key in production
            byte[] iv = "1234567890123456".getBytes(); // Example IV, use a proper IV in production
            byte[] ciphertextBytes = "EncryptedData".getBytes(); // Example ciphertext, use actual encrypted data

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            byte[] recoveredPlaintextBytes = cipher.doFinal(ciphertextBytes);
            String recoveredPlaintext = new String(recoveredPlaintextBytes);

            System.out.println("Recovered Plaintext: " + recoveredPlaintext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}