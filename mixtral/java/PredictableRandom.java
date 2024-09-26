import java.security.*;

public class PredictableRandom {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        new PredictableRandom().execute();
    }

    private void execute() throws NoSuchAlgorithmException {

        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

        long seed = 12345678L;

        System.out.println(secureRandom.getProvider());

        // Set the same seed for both instances

        secureRandom.setSeed(seed);

        System.out.println("First instance: " + secureRandom.nextLong());

        SecureRandom secureRandom2 = SecureRandom.getInstance("SHA1PRNG");

        secureRandom2.setSeed(seed);

        // Both instances should generate the same random number

        System.out.println("Second instance: " + secureRandom2.nextLong());
    }
}