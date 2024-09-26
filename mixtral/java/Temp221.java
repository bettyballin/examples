import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.spec.RSAPublicKeySpec;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class PublicKeyBlobGenerator {
    public static byte[] getPublicKeyBlob() {
        try {
            // Load the keystore (this is just an example, you need to adjust it to your actual keystore)
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(null, null); // Assuming the keystore is empty

            // Retrieve the certificate
            X509Certificate cert = (X509Certificate) keyStore.getCertificate("le-f0b649ee-4e25-4973-a185-efd5bd587c54");

            // Get the public key from the certificate
            PublicKey publicKey = cert.getPublicKey();

            // Create a KeyFactory for RSA
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            // Get the RSA public key specification
            RSAPublicKeySpec rsaPubKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

            // Encode the public key into a SubjectPublicKeyInfo structure
            byte[] publicBlob = new SubjectPublicKeyInfo((ASN1Sequence) ASN1Sequence.fromByteArray(publicKey.getEncoded())).getEncoded();

            return publicBlob;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        byte[] publicKeyBlob = getPublicKeyBlob();
        if (publicKeyBlob != null) {
            System.out.println("Public Key Blob: " + java.util.Base64.getEncoder().encodeToString(publicKeyBlob));
        } else {
            System.out.println("Failed to get public key blob.");
        }
    }
}