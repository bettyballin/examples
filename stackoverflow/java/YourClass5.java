import org.springframework.util.Assert;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.Signer;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class YourClass5 {

    private String signingKey;
    private String verifierKey;
    private Signer signer;
    // Assuming logger is defined somewhere in your class
    // private static final Logger logger = LoggerFactory.getLogger(YourClass5.class);

    public void setSigningKey(String key) {
        Assert.hasText(key);
        key = key.trim();

        this.signingKey = key;

        if (isPublic(key)) {
            signer = new RsaSigner(key);
            // logger.info("Configured with RSA signing key");
        } else {
            // Assume it's a MAC key
            this.verifierKey = key;
            signer = new MacSigner(key);
        }
    }

    private boolean isPublic(String key) {
        try {
            byte[] byteKey = Base64.decode(key.getBytes());
            X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
            KeyFactory kf = KeyFactory.getInstance("RSA");

            PublicKey publicKey = kf.generatePublic(X509publicKey);
            return publicKey != null;
        } catch (Exception e) {
            return false;
        }
    }
}