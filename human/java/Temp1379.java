import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.security.interfaces.ECPublicKey;

public class Temp1379 {

    private static final byte[] P256_HEAD = Base64.getDecoder().decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE");

    /**
     * Converts an uncompressed secp256r1 / P-256 public point to the EC public key it is representing.
     * @param w a 64 byte uncompressed EC point consisting of just a 256-bit X and Y
     * @return an &lt;code&gt;ECPublicKey&lt;/code&gt; that the point represents 
     */
    public static ECPublicKey generateP256PublicKeyFromFlatW(byte[] w) throws InvalidKeySpecException {
        byte[] encodedKey = new byte[P256_HEAD.length + w.length];
        System.arraycopy(P256_HEAD, 0, encodedKey, 0, P256_HEAD.length);
        System.arraycopy(w, 0, encodedKey, P256_HEAD.length, w.length);
        KeyFactory eckf;
        try {
            eckf = KeyFactory.getInstance("EC");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("EC key factory not present in runtime");
        }
        X509EncodedKeySpec ecpks = new X509EncodedKeySpec(encodedKey);
        return (ECPublicKey) eckf.generatePublic(ecpks);
    }

    public static void main(String[] args) {
        // Example usage
        byte[] w = new byte[64]; // Example 64-byte array representing an uncompressed EC point
        try {
            ECPublicKey ecPublicKey = generateP256PublicKeyFromFlatW(w);
            System.out.println("Generated EC Public Key: " + ecPublicKey);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}