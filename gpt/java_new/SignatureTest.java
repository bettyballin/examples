import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.SecureRandom;

public class SignatureTest {
    private static final byte[] MESSAGE = "Test message".getBytes();

    public void rsaSignatureIntegrityTest() throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048, new SecureRandom());
        KeyPair pair = gen.generateKeyPair();

        // Create the digest of the message
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(MESSAGE);

        // Sign the digest with NONEwithRSA
        Signature signer = Signature.getInstance("NONEwithRSA");
        signer.initSign(pair.getPrivate());
        signer.update(digest);
        byte[] signed = signer.sign();

        // Verify the signature
        Signature verifier = Signature.getInstance("NONEwithRSA");
        verifier.initVerify(pair.getPublic());
        verifier.update(digest);
        boolean verified = verifier.verify(signed);

        // Check if the signature verification was successful
        assert verified;
    }
}