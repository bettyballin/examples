import java.security.*;
import java.util.UUID;
import java.io.UnsupportedEncodingException;

public class SecureTokenGenerator {
    private static final String HASH_ALGORITHM = "SHA-256";

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);

        UUID uuid = UUID.randomUUID();

        byte[] hashedBytes = md.digest(uuid.toString().getBytes("UTF-8"));

        String secureToken = bytesToHex(hashedBytes).substring(0, 32);

        System.out.println("Secure Token: " + secureToken);
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];

        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;

            hexChars[j * 2] = HEX_ARRAY[v >>> 4];

            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }

        return new String(hexChars);
    }
}