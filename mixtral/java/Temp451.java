import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcePEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder;
import org.bouncycastle.operator.InputDecryptorProvider;

public class Temp451 {
    public static void main(String[] args) {
        // Example usage (you need to replace the key and password with actual values)
        byte[] key = {}; // Example byte array for the key
        char[] password = {}; // Example password

        try {
            PrivateKey privateKey = decryptPrivateKey(key, password);
            System.out.println("Decrypted Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PrivateKey decryptPrivateKey(byte[] key, char[] password) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        InputStream in = new ByteArrayInputStream(key);

        EncryptedPrivateKeyInfo encryptPKInfo;

        try (ASN1InputStream asn1Input = new ASN1InputStream(in)) {
            DERObject derObj = asn1Input.readObject();

            if (!(derObj instanceof ASN1TaggedObject))
                throw new IllegalArgumentException("Not a tagged object");

            encryptPKInfo = EncryptedPrivateKeyInfo.getInstance((ASN1Sequence) ((DERTaggedObject) derObj).getObject());
        }

        Cipher cipher = Cipher.getInstance(encryptPKInfo.getAlgName(), "BC");

        PBEParameterSpec pbeParamSpec = new PBEParameterSpec(encryptPKInfo.getAlgParameters().getEncoded(), 10000);

        cipher.init(Cipher.DECRYPT_MODE, new javax.crypto.spec.SecretKeySpec(password, "DES"), pbeParamSpec);

        byte[] decryptedKey = cipher.doFinal(encryptPKInfo.getEncryptedData());

        try (PEMParser pemParser = new PEMParser(new ByteArrayInputStream(decryptedKey))) {
            JcePEMKeyConverter converter = new JcePEMKeyConverter().setProvider("BC");
            return converter.getPrivateKey((org.bouncycastle.asn1.pkcs.PrivateKeyInfo) pemParser.readObject());
        }
    }
}