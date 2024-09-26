import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.util.encoders.Base64;

import javax.xml.bind.DatatypeConverter;

public class Temp308 {
    public static void main(String[] args) throws Exception {
        // Simulated private key (replace with actual key)
        String privateKeyPem = "-----BEGIN PRIVATE KEY-----\n"
                + "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAL9KJgGKh6E0pO2J\n"
                + "..."
                + "-----END PRIVATE KEY-----";

        // Remove PEM headers and decode
        privateKeyPem = privateKeyPem.replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "").replaceAll("\\s", "");
        byte[] privateKeyBytes = Base64.decode(privateKeyPem);

        // Generate PrivateKey object
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // Data to sign
        byte[] paramDataToSign = "example data".getBytes();

        // Initialize RSA engine
        AsymmetricBlockCipher rsaEngine = new PKCS1Encoding(new RSABlindedEngine());
        rsaEngine.init(true, org.bouncycastle.crypto.util.PrivateKeyFactory.createKey(privateKey.getEncoded()));

        // Create DigestInfo
        DigestInfo dInfo = new DigestInfo(new AlgorithmIdentifier(X509ObjectIdentifiers.id_SHA1, DERNull.INSTANCE), paramDataToSign);
        byte[] digestInfo = dInfo.getEncoded(ASN1Encoding.DER);

        // Process block
        byte[] signedData = rsaEngine.processBlock(digestInfo, 0, digestInfo.length);

        // Print the signed data
        System.out.println(DatatypeConverter.printHexBinary(signedData));
    }
}