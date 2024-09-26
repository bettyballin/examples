import java.math.BigInteger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp492 {
    public static void main(String[] args) throws Exception {
        // Generate a secret key for demonstration
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example, 128-bit AES
        SecretKey secret_key = keyGen.generateKey();

        // Convert the secret key to hexadecimal format
        String hexKey = new BigInteger(1, secret_key.getEncoded()).toString(16);
        hexKey = hexKey.replaceFirst("^0+(?!$)", "");

        // Print the hexadecimal key
        System.out.println("Hexadecimal Key: " + hexKey);

        // Example IV (Initialization Vector) generation and conversion
        byte[] iv = new byte[16]; // Typically 16 bytes for AES
        new java.security.SecureRandom().nextBytes(iv);

        // Convert the IV to hexadecimal format
        String hexIV = new BigInteger(1, iv).toString(16);
        hexIV = hexIV.replaceFirst("^0+(?!$)", "");

        // Print the hexadecimal IV
        System.out.println("Hexadecimal IV: " + hexIV);
    }
}