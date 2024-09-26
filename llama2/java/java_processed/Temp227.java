import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

public class Temp227 {
    public static void main(String[] args) {
        try (FileReader file = new FileReader("pubkey.pem");
             PemReader reader = new PemReader(file)) {

            PemObject pemObject = reader.readPemObject();
            X509EncodedKeySpec caKeySpec = new X509EncodedKeySpec(pemObject.getContent());
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PublicKey caKey = kf.generatePublic(caKeySpec);
            System.out.println("Public Key: " + caKey);

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}