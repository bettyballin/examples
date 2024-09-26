import java.security.*;
import java.security.spec.*;
import java.math.BigInteger;
import java.io.*;
import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.x9.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp175 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        // Generate ECDSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "BC");
        keyGen.initialize(new ECGenParameterSpec("secp256k1"));
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey spriv = keyPair.getPrivate();
        PublicKey spub = keyPair.getPublic();

        // Sample input data
        byte[] input = "Hello, World!".getBytes();

        // Perform ECDSA signature of the data with SHA-256 as the hash algorithm
        Signature dsa = Signature.getInstance("SHA256withECDSA", "BC");
        dsa.initSign(spriv);
        dsa.update(input);
        byte[] output = dsa.sign();

        // Parse ASN.1 DER encoded signature
        ASN1InputStream asn1Input = new ASN1InputStream(new ByteArrayInputStream(output));
        DERSequence seq = (DERSequence) asn1Input.readObject();
        BigInteger r = ((ASN1Integer) seq.getObjectAt(0)).getValue();
        BigInteger s = ((ASN1Integer) seq.getObjectAt(1)).getValue();

        // Print raw R and S values
        System.out.println("R: " + r.toString(16));
        System.out.println("S: " + s.toString(16));
    }
}