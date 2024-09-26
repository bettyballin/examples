import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

import java.security.SecureRandom;
import java.util.Base64;

public class Temp318 {
    public static void main(String[] args) {
        String password = "your_password_here"; // Replace with the actual password

        // Generate random salt (e.g 16 bytes)
        byte[] salt = new byte[16];
        SecureRandom rng = new SecureRandom();
        rng.nextBytes(salt);

        DefaultHashService hashService = new DefaultHashService();
        hashService.setPrivateSalt(new SimpleByteSource("private_salt".getBytes()));
        hashService.setGeneratePublicSalt(true);
        String hashedPassword = hashService.computeHash(new HashRequest.Builder()
                .setAlgorithmName(Sha256Hash.ALGORITHM_NAME)
                .setIterations(1024) // Number of iterations
                .setSource(ByteSource.Util.bytes(password))
                .setSalt(new SimpleByteSource(salt))
                .build()).toHex();

        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Salt (Base64): " + Base64.getEncoder().encodeToString(salt));
    }
}