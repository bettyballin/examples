import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Temp305 {

    public static void main(String[] args) {
        try {
            File publicKeyFile = new File("path/to/your/publickeyfile.pem");
            PublicKey publicKey = loadPublicKeyFromFile(publicKeyFile);
            System.out.println(publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PublicKey loadPublicKeyFromFile(File publicKeyFile) throws Exception {
        PemReader reader = new PemReader(new FileReader(publicKeyFile));

        // Read the PEM object from the input stream
        PemObject pemObj = reader.readPemObject();
        reader.close();

        if (pemObj.getType().equals("CERTIFICATE")) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(pemObj.getContent()));
            return cert.getPublicKey();
        } else if (pemObj.getType().equals("PUBLIC KEY")) {
            java.security.spec.X509EncodedKeySpec publicKeySpec = new java.security.spec.X509EncodedKeySpec(pemObj.getContent());
            javax.crypto.Cipher.getInstance("RSA"); // to avoid "java.lang.NoClassDefFoundError: com/android/org/bouncycastle/jce/provider/BouncyCastleProvider"
            java.security.KeyFactory kf = java.security.KeyFactory.getInstance("RSA");
            return kf.generatePublic(publicKeySpec);
        }

        throw new IllegalArgumentException("Invalid PEM file: Not a CERTIFICATE or PUBLIC KEY type");
    }
}