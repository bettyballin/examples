import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;

public class Temp2504 {
    private static final String ALGORITHM = "SHA1PRNG";
    private static final String PROVIDER = "SUN";
    private static final java.nio.charset.Charset UTF8_CHARSET = StandardCharsets.UTF_8;

    public static void main(String[] args) {
        Temp2504 temp = new Temp2504();
        try {
            SecureRandom secureRandom = temp.getSecureRandom("exampleSeed");
            System.out.println("SecureRandom object created successfully.");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    private SecureRandom getSecureRandom(String seed) throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom sr = SecureRandom.getInstance(ALGORITHM, PROVIDER);
        sr.setSeed(seed.getBytes(UTF8_CHARSET));
        return sr;
    }
}