import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class CertificateRequestGenerator {

    public PKCS10CertificationRequest generateRequest(KeyPair keyPair) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        // Subject information
        X500Name subject = new X500Name("CN=Test, O=Example, C=US");

        // Create a builder for the certification request
        PKCS10CertificationRequestBuilder p10Builder = new PKCS10CertificationRequestBuilder(subject, keyPair.getPublic());

        // Add extensions if necessary (not shown here)
        ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
        // extensionsGenerator.addExtension(Extension.requestedExtensions, false, new DERSequence()); // Example

        // Sign the certification request
        JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder("SHA256withRSA");
        ContentSigner signer = csBuilder.build(keyPair.getPrivate());
        PKCS10CertificationRequest csr = p10Builder.build(signer);

        return csr;
    }
}