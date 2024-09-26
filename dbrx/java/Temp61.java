import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Temp61 {
    public static void main(String[] args) {
        try {
            byte[] iv = new byte[12]; // Initialization Vector; replace with actual IV
            byte[] data = new byte[64]; // Encrypted data; replace with actual data
            byte[] keyBytes = new byte[16]; // AES key; replace with actual key

            Key secretKey = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
            byte[] decryptedData = cipher.doFinal(data);
            String plainTextData = new String(decryptedData);

            System.out.println(plainTextData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}