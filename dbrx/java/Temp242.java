import org.bouncycastle.crypto.AsymmetricKeyParameter;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.signers.RSADigestSigner;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Arrays;

public class Temp242 {
    public static void main(String[] args) {
        // Generate a key pair
        KeyPair keyPair = generateKeyPair();
        RSAKeyParameters privateKey = new RSAKeyParameters(true, ((PrivateKey) keyPair.getPrivate()).getModulus(), ((PrivateKey) keyPair.getPrivate()).getPrivateExponent());

        // Example usage
        byte[] message = "Hello, World!".getBytes();
        Temp242 temp = new Temp242();
        try {
            byte[] signature = temp.computeSignature(message, privateKey);
            System.out.println("Signature: " + Arrays.toString(signature));
        } catch (CryptoException e) {
            e.printStackTrace();
        }
    }

    public byte[] computeSignature(byte[] message, AsymmetricKeyParameter key) throws CryptoException {
        RSADigestSigner signer = new RSADigestSigner(new SHA256Digest());
        signer.init(true, key);
        signer.update(message, 0, message.length);
        return signer.generateSignature();
    }

    private static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            return kpg.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}