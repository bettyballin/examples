import java.security.*;

public class SignatureGenerator {
    public static void generateSignature(String url) {
        KeyPairGenerator keyGen;
        try {
            keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey priv = pair.getPrivate();
            PublicKey pub = pair.getPublic();

            Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
            dsa.initSign(priv);
            dsa.update(url.getBytes());

            byte[] realSig = dsa.sign();
            // If you need to encode the signature, you can use Base64 Encoder
            // String encodedSig = Base64.getEncoder().encodeToString(realSig);

        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
    }
}