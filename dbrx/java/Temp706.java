import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

public class Temp706 {
    public static void main(String[] args) {
        String initializer = "000102030405060708090a0b0c0d0e0f";
        byte[] keyBytes = new BigInteger(initializer, 16).toByteArray();
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        
        // Print to verify the key
        System.out.println("Key: " + new BigInteger(1, secretKey.getEncoded()).toString(16));
    }
}