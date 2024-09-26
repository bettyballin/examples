import java.security.SecureRandom;
import java.util.Random;

public class Temp1264 {
    public static void main(String[] args) {
        Random rand = new SecureRandom();
        // 0 to 100 inclusive.
        int number = rand.nextInt(101);
        System.out.println("Generated number: " + number);
    }
}