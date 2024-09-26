import javax.crypto.Cipher;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.util.Arrays;

public class Temp60 {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("cryptoFile"); // Replace with actual file path
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            
            // Generate a temporary key pair for demonstration purposes
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair kp = keyGen.generateKeyPair();
            PrivateKey privateKey = kp.getPrivate();
            
            BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(
                    Files.newOutputStream(Paths.get("DecryptedFile.txt")), StandardCharsets.UTF_8));
            
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byte[] decryptedData = cipher.update(Arrays.copyOfRange(buffer, 0, bytesRead));
                outputWriter.write(new String(decryptedData, StandardCharsets.UTF_8));
            }
            
            byte[] finalBlock = cipher.doFinal();
            outputWriter.write(new String(finalBlock, StandardCharsets.UTF_8));
            
            inputStream.close();
            outputWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}