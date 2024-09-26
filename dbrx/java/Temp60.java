import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp60 {
    public static void main(String[] args) throws Exception {
        String plainTextData = "GPS location";
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for example, 256-bit AES
        SecretKey secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] iv = cipher.getIV();
        byte[] encryptedData = cipher.doFinal(plainTextData.getBytes());

        // Assuming 'file' is a valid File object
        String file = "encryptedData.dat";
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(iv); // Save the IV along with the data
        fos.write(encryptedData);
        fos.close();
    }
}