import java.io.IOException;
import java.security.*;
import java.util.Base64;
import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;

public class RSASignatureTest {

    private static final byte[] MESSAGE = "Your message here".getBytes();

    public void rsaSignatureIntegrityTest() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
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
        verifier.verify(signed);
    }

    private byte[] wrapForRsaSign(byte[] dig, String hashAlgo) {
        AlgorithmIdentifier oid = new DefaultDigestAlgorithmIdentifierFinder().find(hashAlgo);
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(oid);
        v.add(new DEROctetString(dig));
        try {
            return new DERSequence(v).getEncoded("DER");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            new RSASignatureTest().rsaSignatureIntegrityTest();
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
    }
}