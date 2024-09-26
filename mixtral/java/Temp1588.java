import java.security.*;
import java.security.spec.*;

public class Temp1588 {
    public static void main(String[] args) {
        // Example usage
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();
            byte[] publicKeyBytes = pair.getPublic().getEncoded();
            byte[] privateKeyBytes = pair.getPrivate().getEncoded();

            RSAPublicKey publicKey = getPublicKeyFromBytes(publicKeyBytes);
            RSAPrivateKey privateKey = getPrivateKeyFromBytes(privateKeyBytes);

            System.out.println("Public Key: " + publicKey);
            System.out.println("Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static RSAPublicKey getPublicKeyFromBytes(byte[] key) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(key);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) kf.generatePublic(spec);
    }

    public static RSAPrivateKey getPrivateKeyFromBytes(byte[] key) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) kf.generatePrivate(spec);
    }
}