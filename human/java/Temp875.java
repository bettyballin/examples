import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Temp875 {

    public static void main(String[] args) {
        String originalDoc = "Sample document content";
        SignerInfo signerInfo = new SignerInfo("SHA-256");
        Signer signer = new Signer();

        byte[] contentDigest = computeDigest(originalDoc, signerInfo.getDigestAlgOID());
        assertArrayEquals(contentDigest, signer.getContentDigest());
    }

    public static byte[] computeDigest(String document, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            return digest.digest(document.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void assertArrayEquals(byte[] a, byte[] b) {
        if (!Arrays.equals(a, b)) {
            throw new AssertionError("Arrays are not equal");
        }
    }

}

class SignerInfo {
    private String digestAlgOID;

    public SignerInfo(String digestAlgOID) {
        this.digestAlgOID = digestAlgOID;
    }

    public String getDigestAlgOID() {
        return digestAlgOID;
    }
}

class Signer {
    public byte[] getContentDigest() {
        // This should return the expected digest for testing
        // Here we simulate the digest computation for "Sample document content" with SHA-256
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest("Sample document content".getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}