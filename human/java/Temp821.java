import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.Digest;

public class Temp821 {
    public static void main(String[] args) {
        byte[] data = "example data".getBytes(); // Example data to be hashed
        Digest md = new SHA256Digest();
        md.reset();
        md.update(data, 0, data.length);
        byte[] hash = new byte[md.getDigestSize()];
        md.doFinal(hash, 0);

        // Print the resulting hash in hexadecimal format
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println(hexString.toString());
    }
}