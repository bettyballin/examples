import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;
import java.security.Security;
import java.security.SecureRandom;

public class Temp120 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        SecureRandom secureRandom = new SecureRandom();
        byte[] aesKeyBytes = new byte[16]; // 128 bits for AES-128
        secureRandom.nextBytes(aesKeyBytes);
        KeyParameter keyParam = new KeyParameter(aesKeyBytes);

        // If you need to convert the bytes back into a string:
        String hexEncodedAesKey = Hex.toHexString(keyParam.getKey());

        // Print the generated key
        System.out.println("Generated AES Key: " + hexEncodedAesKey);
    }
}