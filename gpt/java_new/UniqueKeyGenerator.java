import java.security.SecureRandom;
import java.math.BigInteger;

public class UniqueKeyGenerator {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        String hexString = String.format("%064x", new BigInteger(1, bytes));
        System.out.println(hexString);
    }
}