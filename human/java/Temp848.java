import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class Temp848 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        // Use PKCS10CertificationRequestBuilder here
        PKCS10CertificationRequestBuilder builder = new PKCS10CertificationRequestBuilder();

        System.out.println("PKCS10CertificationRequestBuilder instance created: " + builder);
    }
}