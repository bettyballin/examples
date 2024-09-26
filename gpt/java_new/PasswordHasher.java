import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHasher {
    public static void main(String[] args) {
        String newPassword = "yourPassword"; // The password to hash

        // Hash the password with MD5
        final byte[] md5Hash = DigestUtils.md5(newPassword);

        // Encode the MD5 hash to a Base64 string
        final String base64EncodedMd5Hash = Base64.encodeBase64String(md5Hash);

        System.out.println("MD5 hash (Base64 Encoded): " + base64EncodedMd5Hash);
    }
}