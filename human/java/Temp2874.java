import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp2874 {
    public static void main(String[] args) throws Exception {
        // Add BouncyCastle as a security provider
        Security.addProvider(new BouncyCastleProvider());

        // Example private key in Base64 format (this is just for illustration; in a real scenario, you would provide your actual private key)
        String privateKeyBase64 = "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgk1VJXy0hP1R1n0BqWzS7ZQ+u1k6/2pP7mO1rfv/yS+WhRANCAARUjz2gkW1i8tQb8G6yM2I2dMxRPq5M7UMY0X5zyb0F5Y3xk6PB+Nn/DG6X9ZPz6T0wQw5HhJ6y8O4J5z8yGhYp";

        // Decode the private key
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // Parse the private key
        ASN1Sequence instance = ASN1Sequence.getInstance(privateKey.getEncoded());
        DEROctetString pkOctetString = (DEROctetString) instance.getObjectAt(2);

        ASN1Sequence ecPkSequence = DERSequence.getInstance(pkOctetString.getOctets());
        DEROctetString pkOctets = (DEROctetString) ecPkSequence.getObjectAt(1);

        byte[] bigIntPk = new BigInteger(1, pkOctets.getOctets()).toByteArray();

        // Output the result
        System.out.println(new BigInteger(1, bigIntPk).toString(16));
    }
}