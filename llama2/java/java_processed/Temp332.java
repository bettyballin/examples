import java.security.SecureRandom;
import javax.xml.bind.DatatypeConverter;

public class Temp332 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32]; // 256 bit
        random.nextBytes(key);
        String hexKey = DatatypeConverter.printHexBinary(key).toLowerCase();
        System.out.println("Generated Key: " + hexKey);
    }
}