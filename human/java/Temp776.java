import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequest;

import java.security.Security;

public class Temp776 {
    public static void main(String[] args) {
        // Add BouncyCastle as a security provider
        Security.addProvider(new BouncyCastleProvider());

        try {
            // Assuming you have a PKCS10CertificationRequest object named pkcs10CertRequest
            PKCS10CertificationRequest pkcs10CertRequest = null; // Initialize this with actual data

            JcaPKCS10CertificationRequest jcaCertRequest =
                    new JcaPKCS10CertificationRequest(pkcs10CertRequest.getEncoded()).setProvider("BC");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}