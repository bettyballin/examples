import java.security.*;
import java.util.Base64;
import java.io.IOException;
import org.bouncycastle.asn1.*;

public class Temp2154 {

    private static final byte[] MESSAGE = "Test message".getBytes();

    public static void main(String[] args) {
        try {
            new Temp2154().rsaSignatureIntegrityTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rsaSignatureIntegrityTest() throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048, new SecureRandom());
        KeyPair pair = gen.generateKeyPair();

        byte[] digest = MessageDigest.getInstance("SHA-256").digest(MESSAGE);
        Signature signer = Signature.getInstance("NONEwithRSA");
        signer.initSign(pair.getPrivate());
        signer.update(wrapForRsaSign(digest, "SHA-256"));
        byte[] signed = signer.sign();
        System.out.println(Base64.getEncoder().encodeToString(signed));

        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(pair.getPublic());
        verifier.update(MESSAGE);
        boolean isVerified = verifier.verify(signed);
        System.out.println("Verification result: " + isVerified);
    }

    private byte[] wrapForRsaSign(byte[] dig, String hashAlgo) {
        ASN1ObjectIdentifier oid = new DefaultDigestAlgorithmIdentifierFinder().find(hashAlgo).getAlgorithm();
        ASN1Sequence oidSeq = new DERSequence(new ASN1Encodable[] { oid, DERNull.INSTANCE });
        ASN1Sequence seq = new DERSequence(new ASN1Encodable[] { oidSeq, new DEROctetString(dig) });
        try {
            return seq.getEncoded();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}