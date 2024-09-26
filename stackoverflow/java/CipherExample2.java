import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class CipherExample2 {
    public static void main(String[] args) {
        try {
            byte[] key = /* Initialization of key */;
            byte[] iv = /* Initialization of IV */;
            byte[] ciphertextBytes = /* Initialization of ciphertext */;

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            byte[] recoveredPlaintextBytes = cipher.doFinal(ciphertextBytes);
            String recoveredPlaintext = new String(recoveredPlaintextBytes);

            System.out.println(recoveredPlaintext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}