import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Temp2170 {
    
    public static void main(String[] args) {
        try {
            Path path = Paths.get("fileToDecrypt.p7m");
            byte[] data = Files.readAllBytes(path);
            Key key = getKey(); // Assuming you have a method to retrieve the key
            System.out.println(new String(cmsDecrypt(data, key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] cmsDecrypt(byte[] data, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES"); // Assuming AES encryption
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    private static Key getKey() {
        // Replace with actual key retrieval logic
        String keyString = "1234567890123456"; // Example key
        return new SecretKeySpec(keyString.getBytes(), "AES");
    }
}