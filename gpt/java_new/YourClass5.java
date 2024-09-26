import javax.crypto.spec.IvParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import java.nio.charset.StandardCharsets;

public class YourClass5 {
    private static final String ENCRYPTION_IV = "your-encryption-iv"; // Replace with actual IV

    static AlgorithmParameterSpec makeIv() {
        if (ENCRYPTION_IV.getBytes(StandardCharsets.UTF_8).length != 16) {
            throw new IllegalArgumentException("Invalid IV length: must be 16 bytes long");
        }
        return new IvParameterSpec(ENCRYPTION_IV.getBytes(StandardCharsets.UTF_8));
    }
    
    // Additional methods and class content go here
}