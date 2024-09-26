import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DESedeKeyGen {
    public static void main(String[] args) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
            keyGen.init(168); // Use 168 for Triple DES
            SecretKey key = keyGen.generateKey();
            
            // Use the generated key for your purposes
            // Example: byte[] keyBytes = key.getEncoded();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}