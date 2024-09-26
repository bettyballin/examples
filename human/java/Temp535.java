import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.pkcs.PrivateKeyInfo;

public class Temp535 {
    // Assume ExternalResourcesFacade is a class that provides a method getResourceAsStream to read resources
    private static final ExternalResourcesFacade externalResourcesFacade = new ExternalResourcesFacade();

    public static void main(String[] args) {
        Temp535 temp = new Temp535();
        try {
            X509CertificateHolder signer = temp.loadSigner();
            PrivateKeyInfo key = temp.loadInKey();
            X509CertificateHolder cert = temp.loadCertfile();
            // Process signer, key, and cert as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public X509CertificateHolder loadSigner() throws FileNotFoundException, IOException {
        InputStream inputStream = externalResourcesFacade.getResourceAsStream("path/to/.crt");
        PEMParser parser = new PEMParser(new InputStreamReader(inputStream));
        return (X509CertificateHolder) parser.readObject();
    }

    public PrivateKeyInfo loadInKey() throws FileNotFoundException, IOException {
        InputStream inputStream = externalResourcesFacade.getResourceAsStream("path/to/.key");
        PEMParser parser = new PEMParser(new InputStreamReader(inputStream));
        return (PrivateKeyInfo) parser.readObject();
    }

    public X509CertificateHolder loadCertfile() throws FileNotFoundException, IOException {
        InputStream inputStream = externalResourcesFacade.getResourceAsStream("path/to/.crt");
        PEMParser parser = new PEMParser(new InputStreamReader(inputStream));
        return (X509CertificateHolder) parser.readObject();
    }
}

// Placeholder for the ExternalResourcesFacade class
class ExternalResourcesFacade {
    public InputStream getResourceAsStream(String path) {
        // Implement logic to get resource as stream
        return null;
    }
}