import java.security.*;
import java.util.Base64;

public class Temp109 {
    public static void main(String[] args) {
        String url = "http://example.com";
        GenearetSignature(url);
    }

    public static void GenearetSignature(String url) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");

            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey priv = pair.getPrivate();
            PublicKey pub = pair.getPublic();

            Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
            dsa.initSign(priv);
            dsa.update(url.getBytes());
            byte[] signatureValueArray = dsa.sign();
            String encodedSignatureValue = Base64.getEncoder().encodeToString(signatureValueArray);

            byte[] publicKeyArray = pub.getEncoded();
            String encodedPublicKey = Base64.getEncoder().encodeToString(publicKeyArray);

            System.out.println("publicKey is " + encodedPublicKey);
            System.out.println("signatureValue is " + encodedSignatureValue);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}