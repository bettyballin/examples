import org.bouncycastle.crypto.digests.SHA256Digest;

public class HashExample2 {
    public static void main(String[] args) {
        byte[] data = "Your data to hash".getBytes();
        SHA256Digest md = new SHA256Digest();
        md.reset();
        md.update(data, 0, data.length);
        byte[] hash = new byte[md.getDigestSize()];
        md.doFinal(hash, 0);
        // Now 'hash' contains the SHA-256 hash of 'data'
    }
}