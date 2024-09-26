import java.security.SecureRandom;
import java.util.Arrays;

public class Temp1554 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getId()));
    }

    public static byte[] getId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byteArray = new byte[8];
        secureRandom.nextBytes(byteArray);
        return byteArray;
    }
}