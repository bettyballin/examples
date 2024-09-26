import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyPairExample {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair keyPair = kpg.generateKeyPair();
        PublicKey pub = keyPair.getPublic();
        PrivateKey prv = keyPair.getPrivate();

        byte[] pubBytes = pub.getEncoded();
        byte[] prvBytes = prv.getEncoded();

        // to recover the key
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey prv_recovered = kf.generatePrivate(new PKCS8EncodedKeySpec(prvBytes));
        PublicKey pub_recovered = kf.generatePublic(new X509EncodedKeySpec(pubBytes));

        System.out.println("Private Key: 
" + prv_recovered.toString());
        System.out.println("Public Key: 
" + pub_recovered.toString());
    }
}