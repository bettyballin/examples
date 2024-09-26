import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp222 {
    public static void main(String[] args) throws Exception {
        // Dummy public key in Base64 format for demonstration; replace with your actual key
        String publicKeyPEM = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr5RXF1EBh3bcJr6gJlFh" +
                "K1M8V+1JX2zA5PbKX/5Zxv+Fq4P6D4DNXKiR0eVB3Zn5Kcr0Rj4N9SvKxJBe5i2/" +
                "3X3Sx6w9rCFjZq6kOZ0m0XgFjYtW9zF7Kx8rXKHpCkKxQHhH0X0Z9CboZ5ElD1OZ" +
                "L/0mA7S8A1p3aTWVQ9Fz0wDz5dZqL0V5iX1I36Z8Jq5Rp0wWzEYe8NZFV+0hKJdZ" +
                "C4bK8Ifv9GON9kFQzN6o8X5f2Y8mMPTK+9+F0oydV5mpZlfr6r2b0Lkq4bkbi/5+" +
                "3y4B1A7V4F7X4o8sP0Ux4mA3l2k1xljBo4YyK7R2o1pL25I9F3u8QwIDAQAB";

        // Decode the Base64 encoded public key
        byte[] decodedKey = Base64.getDecoder().decode(publicKeyPEM);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(spec);

        // Generate the filename you want to save the pem file as
        String filename = "public_key.pem";
        FileOutputStream fos = new FileOutputStream(filename);

        JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
        SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance((ASN1Sequence) ASN1Object.fromByteArray(publicKey.getEncoded()));
        PemObject pemObject = new PemObject("PUBLIC KEY", publicKeyInfo.getEncoded());

        try (Writer writer = new OutputStreamWriter(fos)) {
            try (PemWriter pw = new PemWriter(writer)) {
                pw.writeObject(pemObject);
            }
        }
        System.out.println("Public key written to " + filename);
    }
}