import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Temp542 {
    public static void main(String[] args) {
        try {
            // Generate a secret key for DES algorithm
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGen.generateKey();

            // Initialize the cipher for encryption
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

            // Generate a random IV (Initialization Vector)
            byte[] iv = new byte[cipher.getBlockSize()];
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            // Initialize the cipher with the key and IV
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            System.out.println("Cipher initialized successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}