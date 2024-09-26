import java.security.SecureRandom;

public class Main67 {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] seed = new byte[29];
        secureRandom.nextBytes(seed);
    }
}