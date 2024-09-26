import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.params.KDFParameters;
import javax.crypto.spec.SecretKeySpec;

public class Temp900 {
    public static void main(String[] args) {
        
        // Simulating shared secret
        byte[] sharedSecret = "simulated_shared_secret".getBytes();

        // Create a HMAC-based KDF using SHA-512
        SHA512Digest hmacSha512 = new SHA512Digest();
        HKDFBytesGenerator kdfGen = new HKDFBytesGenerator(hmacSha512);

        // Set the input key material (shared secret)
        kdfGen.init(new KDFParameters(sharedSecret, null));

        // Generate a 32-byte AES key
        byte[] derivedKey = new byte[32];
        int len = kdfGen.generateBytes(derivedKey, 0, derivedKey.length);

        if (len < derivedKey.length) {
            throw new IllegalStateException("Could not generate enough bytes for the desired length");
        }

        SecretKeySpec aesKey = new SecretKeySpec(derivedKey, "AES");

        // Print the derived key in hex format
        StringBuilder hexString = new StringBuilder();
        for (byte b : derivedKey) {
            hexString.append(String.format("%02x", b));
        }
        System.out.println("Derived AES Key: " + hexString.toString());
    }
}


Make sure you have the BouncyCastle library added to your project dependencies to run this code successfully.