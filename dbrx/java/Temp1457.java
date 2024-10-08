import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.DrbgParameters;

public class Temp1457 {
    public static void main(String[] args) {
        try {
            SecureRandom random = SecureRandom.getInstance("DRBG", DrbgParameters.instantiation(256, DrbgParameters.Capability.RESEED_ONLY, null));
            byte[] bytes = new byte[16];
            random.nextBytes(bytes);

            // Optionally, print the generated bytes
            System.out.println(java.util.Arrays.toString(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}