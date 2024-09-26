import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.GeneralDigest;
import org.bouncycastle.util.encoders.Base64;

public class Temp1343 {
    public static void main(String[] args) {
        Temp1343 temp = new Temp1343();
        String result = temp.createHash("password", new byte[]{0x01, 0x02, 0x03, 0x00});
        System.out.println(result);
    }

    public String createHash(String input, byte[] salt) {
        GeneralDigest digest = new MD5Digest();

        // Update the hash with your password
        for (byte b : input.getBytes())
            digest.update(b);

        // Add a random value to make it harder
        if (salt != null) {
            for (int i = 0; i < 16 && salt[i] != 0x00; ++i) {
                digest.update((byte) (salt[i]));
            }
        }

        byte[] hash = new byte[digest.getDigestSize()];

        // Get the finalized hash
        digest.doFinal(hash, 0);

        return Base64.toBase64String(hash).trim();
    }
}