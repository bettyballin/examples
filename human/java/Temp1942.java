import java.security.SecureRandom;

public class Temp1942 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        
        // Print the bytes array
        for (byte b : bytes) {
            System.out.printf("%02x ", b);
        }
    }
}