import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.params.HKDFParameters;
import javax.crypto.spec.SecretKeySpec;

public class Temp670 {
    public static void main(String[] args) {

        // Example secret for demonstration purposes
        byte[] alice_secret = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        
        HKDFBytesGenerator hkdf = new HKDFBytesGenerator(new SHA256Digest());
        hkdf.init(HKDFParameters.defaultParameters(alice_secret));
        byte[] derivedKey = new byte[16]; // 128-bit key for AES-128
        hkdf.generateBytes(derivedKey, 0, derivedKey.length);
        SecretKeySpec alice_aes = new SecretKeySpec(derivedKey, "AES");
        
        // Print the derived key for validation
        System.out.print("Derived Key: ");
        for (byte b : derivedKey) {
            System.out.printf("%02x", b);
        }
    }
}