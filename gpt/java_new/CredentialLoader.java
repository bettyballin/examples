import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;

import org.opensaml.security.credential.Credential;
import org.opensaml.security.credential.BasicCredential;
import org.opensaml.security.x509.BasicX509Credential;

public class CredentialLoader {

    private static final String CERTIFICATE_FILE_PATH = "path/to/certificate.crt";
    private static final String PRIVATE_KEY_FILE_PATH = "path/to/private_key.pk8";

    public Credential getSigningCredential() throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        
        FileInputStream certificateStream = new FileInputStream(CERTIFICATE_FILE_PATH);
        X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(certificateStream);
        certificateStream.close();
        
        File privateKeyFile = new File(PRIVATE_KEY_FILE_PATH);
        byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        
        BasicX509Credential credential = new BasicX509Credential(certificate, privateKey);
        
        return credential;
    }
}