import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp899 {
    public static void main(String[] args) {
        try {
            String pemString = "full private key string here";
            pemString = pemString.replace("-----BEGIN RSA PRIVATE KEY-----", "");
            pemString = pemString.replace("-----END RSA PRIVATE KEY-----", "");
            pemString = pemString.replace("\n", "");

            byte[] decoded = Base64.getDecoder().decode(pemString);
            KeyFactory kf = KeyFactory.getInstance("RSA");

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
            PrivateKey privatekey = kf.generatePrivate(keySpec);
            RSAPrivateCrtKey privk = (RSAPrivateCrtKey) privatekey;

            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(privk.getModulus().toByteArray());
            RSAPublicKey pubKey = (RSAPublicKey) kf.generatePublic(publicKeySpec);
            String pubString = Base64.getEncoder().encodeToString(pubKey.getEncoded());

            System.out.println("Public Key: " + pubString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}