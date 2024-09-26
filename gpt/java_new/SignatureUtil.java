import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class SignatureUtil {

    public static byte[] sign(byte[] message, BigInteger privateExponent, BigInteger modulus)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        // Initialize signature
        Signature sig = Signature.getInstance("MD5WithRSA");

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(modulus, privateExponent);
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

        sig.initSign(privateKey);

        sig.update(message);

        return sig.sign();
    }

    public static boolean verify(byte[] message, byte[] signature, BigInteger publicExponent, BigInteger modulus)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        // Initialize signature
        Signature sig = Signature.getInstance("MD5WithRSA");

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(modulus, publicExponent);
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        sig.initVerify(publicKey);

        sig.update(message);

        return sig.verify(signature);
    }
}