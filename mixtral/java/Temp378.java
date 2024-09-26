import java.io.FileReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.openssl.PEMParser;

public class Temp378 {
    public static void main(String[] args) {
        try {
            PublicKey publicKey = loadPublicKeyFromFile("path/to/your/public/key.pem");
            System.out.println("Public Key: " + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PublicKey loadPublicKeyFromFile(String filename) throws Exception {
        FileReader file = new FileReader(filename);
        PEMParser pemParser = new PEMParser(file);
        SubjectPublicKeyInfo subjectPublicKeyInfo = (SubjectPublicKeyInfo) pemParser.readObject();
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey = kf.generatePublic(new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded()));
        pemParser.close();
        file.close();
        return publicKey;
    }
}