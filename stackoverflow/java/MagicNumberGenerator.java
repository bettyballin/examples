import java.security.SecureRandom;
import java.util.Random;

public class MagicNumberGenerator {
    public static void main(String[] args) {
        Random rand = new SecureRandom();
        int magic = 1 + rand.nextInt(10);
        System.out.println(magic);
    }
}