import java.security.*;
import java.security.spec.RSAKeyGenParameterSpec;

public class RsaKeyPairGenerator {

    public static KeyPair generateRsaKeyPairFromPassword(String password) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        // Step 1: Create a hash of the password to use as the PRNG seed
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] passwordHash = sha256.digest(password.getBytes());

        // Step 2: Initialize a SecureRandom with the password hash
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(passwordHash);

        // Step 3: Generate the RSA KeyPair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(new RSAKeyGenParameterSpec(2048, RSAKeyGenParameterSpec.F4), secureRandom);
        return keyPairGenerator.generateKeyPair();
    }

    public static void main(String[] args) {
        try {
            KeyPair keyPair = generateRsaKeyPairFromPassword("mySecurePassword");
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            // Use the keys as required
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}