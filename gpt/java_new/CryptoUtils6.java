import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

public class CryptoUtils6 {
    private static final String ALGORITHM = "AES";
    
    public void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(cipherMode, secretKey);
        
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] inputBytes = new byte[(int) inputFile.length()];
            int bytesRead = inputStream.read(inputBytes);
            
            byte[] outputBytes = cipher.doFinal(inputBytes, 0, bytesRead);
            
            outputStream.write(outputBytes);
        }
    }
}