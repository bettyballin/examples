import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cms.CMSEnvelopedDataParser;
import org.bouncycastle.cms.RecipientInformationStore;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.pkcs.PKCSException;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfoBuilder;
import org.bouncycastle.pkcs.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.X509Certificate;

public class Temp1322 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        PEMParser pemParser = new PEMParser(new InputStreamReader(new FileInputStream("privateKey.pem")));
        Object obj;
        PrivateKey key = null;
        X509Certificate cert1 = null, cert2 = null;

        while ((obj = pemParser.readObject()) != null) {
            if (obj instanceof PKCS8EncryptedPrivateKeyInfo) {
                JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
                PKCS8EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = (PKCS8EncryptedPrivateKeyInfo) obj;
                key = converter.getPrivateKey(encryptedPrivateKeyInfo.decryptPrivateKeyInfo(
                        new JceOpenSSLPKCS8DecryptorProviderBuilder().build("password".toCharArray())));

            } else if (obj instanceof X509CertificateHolder) {
                if (cert1 == null) {
                    cert1 = new JcaX509CertificateConverter().setProvider("BC").getCertificate((X509CertificateHolder) obj);
                } else {
                    cert2 = new JcaX509CertificateConverter().setProvider("BC").getCertificate((X509CertificateHolder) obj);
                }
            }
        }

        // For encrypted data
        CMSEnvelopedDataParser envParser = new CMSEnvelopedDataParser(
                new FileInputStream("fileToDecrypt.p7m"));
        RecipientInformationStore recipients = envParser.getRecipientInfos();
    }
}