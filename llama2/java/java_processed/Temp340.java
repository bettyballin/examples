import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInfoGenerator;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;

public class Temp340 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        // Example usage (you need to replace these with actual working values)
        byte[] dataToSign = "Hello, World!".getBytes();
        byte[] signedData; // This will store the signed data

        try {
            // Create a CMSProcessableByteArray from the data to sign
            CMSProcessableByteArray cmsData = new CMSProcessableByteArray(dataToSign);

            // Generate a private key and certificate for signing
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048, new SecureRandom());
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();

            // Create a SignerInfoGenerator
            ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256withRSA").build(privateKey);
            SignerInfoGenerator signerInfoGenerator = new JcaSignerInfoGeneratorBuilder(new JcaContentSignerBuilder("SHA256withRSA").build(privateKey)).build(contentSigner, new X509CertificateHolder(keyPair.getPublic().getEncoded()));

            // Create a CMSSignedData
            CMSSignedData cmsSignedData = new CMSSignedData(cmsData, new DERSequence());

            // Add the signer info
            cmsSignedData = CMSSignedData.replaceSigners(cmsSignedData, signerInfoGenerator);

            // Get the signed data
            signedData = cmsSignedData.getEncoded();

            // Print the signed data (in base64 for readability)
            System.out.println(java.util.Base64.getEncoder().encodeToString(signedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}