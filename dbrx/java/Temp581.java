import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PrivateKeyFactory;

public class Temp581 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());

            // Assume privateKeyBytes is the byte array of your private key in PKCS8 format
            byte[] privateKeyBytes = {/* Your Private Key Bytes Here */};

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            AsymmetricBlockCipher rsaEngine = new PKCS1Encoding(new RSABlindedEngine());
            AsymmetricKeyParameter privateKeyParam = PrivateKeyFactory.createKey(privateKey.getEncoded());
            rsaEngine.init(true, privateKeyParam);

            byte[] paramDataToSign = {/* Your data to sign */};

            DigestInfo dInfo = new DigestInfo(
                new AlgorithmIdentifier(X509ObjectIdentifiers.id_SHA1, DERNull.INSTANCE), paramDataToSign);
            byte[] digestInfo = dInfo.getEncoded(ASN1Encoding.DER);

            byte[] encryptedData = rsaEngine.processBlock(digestInfo, 0, digestInfo.length);

            // Output the encrypted data
            System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}