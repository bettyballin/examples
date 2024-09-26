import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Temp2599 {
    public static void main(String[] args) {
        SecretKey key = generate192Bit3DESKey();
        System.out.println("Key: " + key);
    }

    public static SecretKey generate192Bit3DESKey() {
        KeyGenerator keyGen;
        try {
            keyGen = KeyGenerator.getInstance("DESede");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("DESede functionality is required for Java, but it is missing", e);
        }

        // NOTE: this is the effective key size excluding parity bits
        // use 112 for two key (ABA) triple DES keys (not recommended)
        keyGen.init(168);

        // this does adjust parity
        SecretKey desABCKey = keyGen.generateKey();
        return desABCKey;
    }
}