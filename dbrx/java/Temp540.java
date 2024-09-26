import java.io.FileReader;
import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.PEMKeyPair;

public class Temp540 {
    public static void main(String[] args) {
        try {
            PublicKey publicKey = publicKeyRead("path_to_your_key_file.pem");
            System.out.println(publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PublicKey publicKeyRead(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        FileReader reader = new FileReader(filename);
        PEMParser parser = new PEMParser(reader);

        Object obj = parser.readObject();

        JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
        KeyPair kp = null;
        if (obj instanceof PEMEncryptedKeyPair) {
            // handle encrypted key pairs if necessary
        } else {
            kp = converter.getKeyPair((PEMKeyPair) obj);
        }

        parser.close();
        reader.close();

        if (kp != null) {
            return kp.getPublic();
        } else {
            throw new InvalidKeySpecException("Could not convert key pair.");
        }
    }
}