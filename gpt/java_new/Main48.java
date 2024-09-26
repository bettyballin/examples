import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.X509Certificate;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Main48 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyStore msCertStore = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
        msCertStore.load(null, null);
        X509Certificate c = (X509Certificate) msCertStore.getCertificate("Software View Certificate Authority");
        PublicKey pubKey = c.getPublicKey();

        File file = new File("C:\\Users\\mayooranM\\Desktop\\SignatureVerificationTest\\ProcessExplorer.zip");
        byte[] fileContent = new byte[(int) file.length()];
        try (FileInputStream fin = new FileInputStream(file)) {
            fin.read(fileContent);
        }

        File signedData = new File(
                "C:\\Users\\mayooranM\\Desktop\\SignatureVerificationTest\\SignedProcessExplorer.sig");
        // Processing of signedData would go here
    }
}