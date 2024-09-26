import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public class Temp3348 {
    public static void main(String[] args) {
        try {
            // Add BouncyCastle as a Security Provider
            Security.addProvider(new BouncyCastleProvider());

            // Generate the X25519 private key
            KeyFactory keyFactory = KeyFactory.getInstance("X25519", "BC");
            PrivateKey privateKey = keyFactory.generatePrivate(new X509EncodedKeySpec(new byte[32])); // Dummy private key

            // Get the public key bytes
            byte[] publicBytes = privateKey.getEncoded();

            // Read keyshare from file
            File keyshareFile = new File("keyshare_kotlin");
            byte[] keyshareKotlin = new byte[(int) keyshareFile.length()];
            try (InputStream inputStream = new FileInputStream(keyshareFile)) {
                inputStream.read(keyshareKotlin);
            }

            // Construct the final public key bytes
            byte[] combinedKey = Arrays.copyOfRange(publicBytes, 0, 12);
            combinedKey = Arrays.copyOf(combinedKey, combinedKey.length + keyshareKotlin.length - 14);
            System.arraycopy(keyshareKotlin, 14, combinedKey, 12, keyshareKotlin.length - 14);

            // Load the public key
            PublicKey loadedKeyshare = keyFactory.generatePublic(new X509EncodedKeySpec(combinedKey));

            // Print out the public key in hex format
            System.out.println("Loaded Public Key: " + Hex.toHexString(loadedKeyshare.getEncoded()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


Note: This code requires the BouncyCastle library. You can add it to your project via Maven or manually download the JAR from [BouncyCastle's official site](https://www.bouncycastle.org/latest_releases.html).