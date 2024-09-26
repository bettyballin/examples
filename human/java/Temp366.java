import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.Strings;

public class Temp366 {
    public static void main(String[] args) throws Exception {
        int iterations = 1000; // minimum
        int keySize = 256; // maximum
        final byte[] salt = new byte[8];
        SecureRandom rng = SecureRandom.getInstance("SHA1PRNG");
        rng.nextBytes(salt);
        char[] password = new char[] { 'o', 'w', 'l', 's', 't', 'e', 'a', 'd' };

        // S2 *is* PBKDF2, but the default used only HMAC(SHA-1)
        final PKCS5S2ParametersGenerator gen = new PKCS5S2ParametersGenerator(new SHA256Digest());

        // lets not use String, as we cannot destroy strings, BC to the rescue!
        final byte[] pwBytes = Strings.toUTF8ByteArray(password);

        gen.init(pwBytes, salt, iterations);

        final KeyParameter params1 = (KeyParameter) gen.generateDerivedParameters(keySize);

        // use for/next loop for older Java versions, destroy password information in memory
        Arrays.fill(pwBytes, 0, pwBytes.length, (byte) 0);
        Arrays.fill(password, 0, password.length, ' ');
        final KeyParameter keyParam = params1;
        SecretKeySpec secretKey = new SecretKeySpec(keyParam.getKey().clone(), "AES");

        System.out.println("SecretKey: " + Arrays.toString(secretKey.getEncoded()));
    }
}


To run this code, you will need to include the Bouncy Castle library in your project. You can download it from [Bouncy Castle](https://www.bouncycastle.org/latest_releases.html) and include it in your classpath, or use a build tool like Maven or Gradle to manage the dependency.