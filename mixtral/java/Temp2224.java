import java.io.StringWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp2224 {
    public static void main(String[] args) throws Exception {
        // Register BouncyCastle as a security provider
        java.security.Security.addProvider(new BouncyCastleProvider());

        // Assuming privateKeyInfo is already defined somewhere
        // For the sake of example, let's define a mock privateKeyInfo
        byte[] privateKeyInfoBytes = Base64.getDecoder().decode("MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgXkWl3R9Yv7D2F3bK3PzZP5g6JQ3QmHh3Fv7yZ7K5WzihRANCAAQvBx7W7ez0aIffG6XH6Q6I5iX3+Y+w+zC6tY9cT+u0P0L5s0X7d0K5IFb+p4Zl5Kc7r4Ydo6zye5fJiy1E8L8Z");
        PKCS8EncodedKeySpec privateKeyInfo = new PKCS8EncodedKeySpec(privateKeyInfoBytes);

        StringWriter str = new StringWriter();
        JcaPEMWriter pemWriter = new JcaPEMWriter(str);
        pemWriter.writeObject(privateKeyInfo);
        pemWriter.close();

        String privateKeyPEM = str.toString()
                                    .replace("-----BEGIN PRIVATE KEY-----", "")
                                    .replace("-----END PRIVATE KEY-----", "")
                                    .replaceAll("\\s", "");

        PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyPEM));

        PrivateKey privateKey = KeyFactory.getInstance("EC", "BC").generatePrivate(privKeySpec);

        System.out.println("Private Key: " + privateKey);
    }
}