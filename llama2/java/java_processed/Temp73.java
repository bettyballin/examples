import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp73 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        
        // Generate a secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example, 128-bit AES
        SecretKey skey = keyGen.generateKey();
        
        // Sample data to encrypt
        byte[] data = "1234567890123456".getBytes(); // AES requires block size of 16 bytes
        
        // Create cipher instance and initialize
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, skey);
        
        // Perform encryption
        byte[] encryptedData = cipher.doFinal(data);
        
        // Print encrypted data
        System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(encryptedData));
    }
}