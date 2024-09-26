import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.interfaces.RSAPublicKey;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

public class KeyPairExample {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider()); // Add BouncyCastle Provider

        // Generate RSA key pair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair keyPair = kpg.genKeyPair();

        // Print Public key in PEM format
        System.out.println("Public key:\n" + getPemFormat(keyPair.getPublic()));

        // Print Private key in PEM format
        System.out.println("Private Key:\n" + getPemFormat(keyPair.getPrivate()));
    }

    public static String getPemFormat(PublicKey key) throws Exception {
        SubjectPublicKeyInfo spki = new SubjectPublicKeyInfo(ASN1Sequence.getInstance(key.getEncoded()));
        StringWriter str = new StringWriter();
        JcaPEMWriter pw = new JcaPEMWriter(str);
        try {
            pw.writeObject(spki);
            return str.toString();
        } finally {
            pw.close();
        }
    }

    public static String getPemFormat(PrivateKey key) throws Exception {
        PrivateKeyInfo pkinfo = PrivateKeyInfo.getInstance(key.getEncoded());
        StringWriter str = new StringWriter();
        JcaPEMWriter pw = new JcaPEMWriter(str);
        try {
            pw.writeObject(pkinfo);
            return str.toString();
        } finally {
            pw.close();
        }
    }
}