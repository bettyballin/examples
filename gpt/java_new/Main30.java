import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Main30 {

    public static byte[] sha256digest16(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] hash = digest.digest();

        byte[] key = new byte[16];
        System.arraycopy(hash, 0, key, 0, key.length);
        return key;
    }

    public static void main(String[] args) {
        try {
            byte[] key = sha256digest16("example");
            System.out.println(new BigInteger(1, key).toString(16));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}