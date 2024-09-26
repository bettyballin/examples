import org.bouncycastle.cms.CMSProcessableFile;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.FileInputStream;
import java.io.FileReader;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Collection;

public class DecryptP7M {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        // Read the private key
        PEMParser pemParser = new PEMParser(new FileReader("privateKey.pem"));
        Object obj;
        PrivateKey privateKey = null;

        JcaPEMKeyConverter converter = new JcaPEMKeyConverter();

        while ((obj = pemParser.readObject()) != null) {
            if (obj instanceof org.bouncycastle.asn1.pkcs.PrivateKeyInfo) {
                privateKey = converter.getPrivateKey((org.bouncycastle.asn1.pkcs.PrivateKeyInfo) obj);
                System.out.println("Private Key found");
                break;
            }
        }

        pemParser.close();

        if (privateKey == null) {
            throw new IllegalStateException("Private key not found");
        }

        // Read the .p7m file
        FileInputStream fis = new FileInputStream("fileToDecrypt.p7m");
        CMSSignedData signedData = new CMSSignedData(fis);
        SignerInformationStore signerInfoStore = signedData.getSignerInfos();
        Collection<org.bouncycastle.cms.SignerInformation> signers = signerInfoStore.getSigners();

        // Verify the signature
        for (org.bouncycastle.cms.SignerInformation signer : signers) {
            if (!signer.verify(new JcaSimpleSignerInfoVerifierBuilder().build((X509Certificate) signer.getSID().getSubject()))) {
                throw new IllegalStateException("Signature verification failed");
            }
        }

        // Decrypt the content
        CMSProcessableFile cmsData = (CMSProcessableFile) signedData.getSignedContent().getContent();
        byte[] decryptedBytes = (byte[]) cmsData.getContent();

        System.out.println(new String(decryptedBytes));
    }
}