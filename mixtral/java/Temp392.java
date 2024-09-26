import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.encoders.Hex;

public class Temp392 {
    public static void main(String[] args) throws Exception {
        String tmpSessionId = "exampleSessionId";
        byte[] input = ("X-Seesson-Sig" + tmpSessionId + "test").getBytes("UTF8");

        SHA256Digest digest = new SHA256Digest();
        digest.update(input, 0, input.length);

        byte[] output = new byte[digest.getDigestSize()];
        digest.doFinal(output, 0);

        String hash = new String(Hex.encode(output));
        System.out.println(hash);
    }
}