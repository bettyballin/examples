import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import sun.security.provider.Sun;

public class Temp1138 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new Sun());
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}