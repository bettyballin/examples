import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyRefactorExample1 {
    public static void main(String[] args) throws Exception {
        String serializedKey = "..."; // Placeholder for the serialized key
        byte[] encodedKey = serializedKey.getBytes(); // Example conversion, may differ based on encoding

        PKCS8EncodedKeySpec formattedPrivate = new PKCS8EncodedKeySpec(encodedKey);
        X509EncodedKeySpec formattedPublic = new X509EncodedKeySpec(encodedKey);

        KeyFactory kf = KeyFactory.getInstance("EC");
        PublicKey pub = kf.generatePublic(formattedPublic);
        PrivateKey priv = kf.generatePrivate(formattedPrivate);
    }
}