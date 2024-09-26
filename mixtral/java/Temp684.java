import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedDataStreamGenerator;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.util.encoders.Base64;

import java.io.FileInputStream;
import java.security.Security;
import java.util.Arrays;

public class Temp684 {
    public static void main(String[] args) throws Exception {
        // Load the keystore
        FileInputStream is = new FileInputStream("your_keystore.jks");
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(is, "your_keystore_password".toCharArray());

        // Get certificate and private key
        String alias = "your_alias";
        X509Certificate cert = (X509Certificate) ks.getCertificate(alias);
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, "your_key_password".toCharArray());

        // Initialize BouncyCastle provider
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        // Set up the generator
        CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
        gen.addSignerInfoGenerator(
            new JcaContentSignerBuilder("SHA1withRSA").setProvider("BC").build(privateKey),
            cert
        );
        gen.addCertificates(new JcaCertStore(Arrays.asList(cert)));

        // Create signed data
        CMSProcessableByteArray processable = new CMSProcessableByteArray("your_data".getBytes());
        byte[] signedData = gen.generate(processable, true).getEncoded();

        // Encode to Base64
        String encodedData = new String(Base64.encode(signedData));
        System.out.println(encodedData);
    }
}