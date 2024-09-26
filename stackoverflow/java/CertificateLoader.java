import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CertificateLoader {

    private final ExternalResourcesFacade externalResourcesFacade;

    public CertificateLoader(ExternalResourcesFacade externalResourcesFacade) {
        this.externalResourcesFacade = externalResourcesFacade;
    }

    public X509CertificateHolder loadCertificate(String resourcePath) throws FileNotFoundException, IOException {
        try (InputStream inputStream = externalResourcesFacade.getResourceAsStream(resourcePath);
             PEMParser parser = new PEMParser(new InputStreamReader(inputStream))) {
            return (X509CertificateHolder) parser.readObject();
        }
    }

    public PrivateKeyInfo loadPrivateKey(String resourcePath) throws FileNotFoundException, IOException {
        try (InputStream inputStream = externalResourcesFacade.getResourceAsStream(resourcePath);
             PEMParser parser = new PEMParser(new InputStreamReader(inputStream))) {
            return (PrivateKeyInfo) parser.readObject();
        }
    }
}

interface ExternalResourcesFacade {
    InputStream getResourceAsStream(String path) throws FileNotFoundException;
}