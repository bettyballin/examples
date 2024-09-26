import java.security.SecureRandom;
import java.util.Arrays;

public class Temp1456 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
    }
}