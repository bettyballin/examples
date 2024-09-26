import java.security.SecureRandom;

public class RandomNumberGenerator {
    private SecureRandom random;

    public RandomNumberGenerator() {
        this.random = new SecureRandom();
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public static void main(String[] args) {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        System.out.println("Random number: " + rng.nextInt(100));
    }
}