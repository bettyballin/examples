import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.SecureRandom;

public class Temp1203 {
    public static void main(String[] args) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] initVector = new byte[12];
            random.nextBytes(initVector);
            byte[] data = new byte[32];
            random.nextBytes(data);
            byte[] key = new byte[32];
            random.nextBytes(key);

            // Authentication
            Cipher cipher1 = Cipher.getInstance("AES/GCM/NoPadding");
            cipher1.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
            cipher1.updateAAD(data, 0, 16);
            byte[] authTag = cipher1.doFinal(new byte[0]);

            // Encryption
            Cipher cipher2 = Cipher.getInstance("AES/GCM/NoPadding");
            cipher2.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new javax.crypto.spec.GCMParameterSpec(128, initVector));
            byte[] encrypted = cipher2.doFinal(data);

            System.out.println("AuthTag: " + new BigInteger(1, authTag).toString(16));
            System.out.println("Encrypted Data: " + new BigInteger(1, encrypted).toString(16));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}