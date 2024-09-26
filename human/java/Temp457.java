import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class Temp457 {
    private RSAKeyParameters rsaServerPublicKey;

    public static void main(String[] args) {
        try {
            Temp457 temp = new Temp457();
            X509Certificate cert = temp.generateCertificateFromString("YOUR_CERTIFICATE_STRING_HERE");
            temp.processServerCertificate(cert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processServerCertificate(Certificate serverCertificate) throws IOException {
        X509Certificate x509Cert = (X509Certificate) serverCertificate;
        SubjectPublicKeyInfo subPubKeyInfo = SubjectPublicKeyInfo.getInstance(x509Cert.getPublicKey().getEncoded());
        RSAPublicKey pubKey = RSAPublicKey.getInstance(subPubKeyInfo.parsePublicKey());
        rsaServerPublicKey = new RSAKeyParameters(false, pubKey.getModulus(), pubKey.getPublicExponent());
        System.out.println("RSA Public Key: " + rsaServerPublicKey);
    }

    public X509Certificate generateCertificateFromString(String certString) throws CertificateException {
        byte[] certBytes = Base64.getDecoder().decode(certString);
        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) factory.generateCertificate(new java.io.ByteArrayInputStream(certBytes));
    }
}