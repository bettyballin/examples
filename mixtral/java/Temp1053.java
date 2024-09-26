import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

public class Temp1053 {
    public static void main(String[] args) {
        try {
            File privateKeyFile = new File("path to .pem file");

            PEMParser pemParser = new PEMParser(new InputStreamReader(new FileInputStream(privateKeyFile)));

            Object object = pemParser.readObject();

            if (object instanceof PrivateKeyInfo) {
                PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(((PrivateKeyInfo) object).getEncoded());

                KeyFactory keyFactory = KeyFactory.getInstance("RSA");

                PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

                Signature signature = Signature.getInstance("SHA1withRSA");

                signature.initSign(privateKey);

                // ...
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}