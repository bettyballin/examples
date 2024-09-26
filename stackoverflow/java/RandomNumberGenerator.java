import java.security.SecureRandom;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        SecureRandom rand = new SecureRandom();
        // 0 to 100 inclusive.
        int number = rand.nextInt(101);
        System.out.println(number);
    }
}