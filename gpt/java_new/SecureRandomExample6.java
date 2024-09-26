import java.security.*;
import java.security.spec.*;

public class SecureRandomExample6 {
    public static void main(String[] args) {
        try {
            // Specify the DRBG type you want, for example HMAC_DRBG
            DrbgParameters.Instantiation drbgParams = DrbgParameters.instantiation(
                    256, DrbgParameters.Capability.PR_AND_RESEED, null);

            // Get an instance of SecureRandom with the specified DRBG type
            SecureRandom secureRandom = SecureRandom.getInstance("DRBG", drbgParams);

            // You can now use secureRandom for cryptographic operations
            byte[] randomBytes = new byte[32];
            secureRandom.nextBytes(randomBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}