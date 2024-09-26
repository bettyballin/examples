import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Temp410 {
    public static void main(String[] args) {
        try {
            byte[] encKey = {/* some byte array representing the encoded key */};
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
            KeyFactory kf = KeyFactory.getInstance("DSA", "SUN");
            PublicKey pubKey = kf.generatePublic(pubKeySpec);

            System.out.println(pubKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}