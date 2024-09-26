import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.util.Selector;
import org.bouncycastle.x509.X509CertStoreSelector;

import java.security.cert.CertStore;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;

public class SignatureValidator {
    public static boolean isValid(CMSSignedData signedData, X509Certificate rootCert) throws Exception {
        CertStore certsAndCRLs = signedData.getCertificatesAndCRLs("Collection", "BC");
        SignerInformationStore signers = signedData.getSignerInfos();
        Iterator<SignerInformation> it = signers.getSigners().iterator();

        if (it.hasNext()) {
            SignerInformation signer = it.next();
            X509CertStoreSelector signerConstraints = new X509CertStoreSelector();

            signerConstraints.setSerialNumber(signer.getSID().getSerialNumber());
            signerConstraints.setIssuer(signer.getSID().getIssuer().getEncoded());

            Collection<? extends java.security.cert.Certificate> matchedCerts =
                    certsAndCRLs.getCertificates((Selector) signerConstraints);

            Iterator<? extends java.security.cert.Certificate> certIt = matchedCerts.iterator();
            if (certIt.hasNext()) {
                X509Certificate cert = (X509Certificate) certIt.next();
                // Add your validation logic here
                // For example, check if cert is issued by rootCert
                // Return true if valid, false otherwise
            }
        }
        return false; // Return false if no valid signature found
    }
}