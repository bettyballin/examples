import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.util.io.pem.PemReader;

import java.security.PrivateKey;

public class Temp1239 {
    public static void main(String[] args) {
        try {
            FileInputStream fis1 = new FileInputStream("publickey");
            byte[] publicBytes = IOUtils.toByteArray(fis1);
            McElieceCCA2PublicKeyParameters pubParams = (McElieceCCA2PublicKeyParameters) PublicKeyFactory
                    .createKey(SubjectPublicKeyInfo.getInstance(ASN1Sequence
                            .fromByteArray(publicBytes)));

            FileInputStream fis2 = new FileInputStream("privatekey");
            PemReader pemReader = new PemReader(new java.io.InputStreamReader(fis2));
            PEMParser pemParser = new PEMParser(pemReader);
            PEMKeyPair pemKeyPair = (PEMKeyPair) pemParser.readObject();
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
            PrivateKey privKey = converter.getPrivateKey(pemKeyPair.getPrivateKeyInfo());

            fis1.close();
            fis2.close();
            pemReader.close();
            pemParser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}