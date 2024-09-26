import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

import java.io.StringWriter;
import java.security.Security;

public class Temp569 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        // Example certificate data
        byte[] certData = {}; // You need to fill this with actual certificate data

        X509CertificateHolder certHolder = new X509CertificateHolder(certData);

        StringWriter sw = new StringWriter();
        JcaPEMWriter pw = new JcaPEMWriter(sw);

        pw.writeObject(certHolder.getSubjectPublicKeyInfo());
        pw.close();

        String pemKey = sw.toString();
        System.out.println(pemKey);
    }
}