import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.SecureRandom;

public class McElieceKeyPairRefactor {
    public static void main(String[] args) throws Exception {
        int keysize = 2048; // Assuming keysize is defined somewhere in the code
        KeyPairGenerator mcElieceKeyPairGenerator = KeyPairGenerator.getInstance("McEliece");
        mcElieceKeyPairGenerator.initialize(keysize, new SecureRandom());
        KeyPair kp = mcElieceKeyPairGenerator.generateKeyPair();

        final byte[] publicKeyData = kp.getPublic().getEncoded();
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyData);
        KeyFactory mcElieceKeyFactory = KeyFactory.getInstance("McEliece");
        PublicKey regeneratedPublicKey = mcElieceKeyFactory.generatePublic(publicKeySpec);

        final byte[] privateKeyData = kp.getPrivate().getEncoded();
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyData);
        PrivateKey regeneratedPrivateKey = mcElieceKeyFactory.generatePrivate(privateKeySpec);
    }
}