import java.security.SecureRandom;
import java.util.Random;

public class Temp2350 {
    public static void main(String[] args) {
        Random rand = new SecureRandom();
        int magic = 1 + rand.nextInt(10);
        System.out.println("Magic number: " + magic);
    }
}