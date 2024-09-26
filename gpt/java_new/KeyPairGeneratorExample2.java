import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;

public class KeyPairGeneratorExample2 {
    public static void main(String[] args) {
        try {
            // Specify the key size and the public exponent
            int keySize = 2048;
            BigInteger publicExponent = new BigInteger("65537"); // commonly used public exponent

            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

            // Initialize KeyPairGenerator with custom public exponent
            RSAKeyGenParameterSpec spec = new RSAKeyGenParameterSpec(keySize, publicExponent);
            kpg.initialize(spec);

            KeyPair kp = kpg.genKeyPair();
            PublicKey publicKey = kp.getPublic();
            PrivateKey privateKey = kp.getPrivate();
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}