import org.apache.commons.codec.binary.Base64;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class Main {
    public static void main(String[] args) throws Exception{
        String pubKey = "ssh-rsa AA...==";

        // Extract the base64 encoded part
        int startIndex = pubKey.indexOf(" ") + 1;
        byte[] keyBytes = Base64.decodeBase64(pubKey.substring(startIndex));

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Calculate the fingerprint
        String fingerPrintHex = bytesToHexString(md.digest(keyBytes)).toLowerCase();

        System.out.println(fingerPrintHex);
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHexString(byte[] bytes) {
      char[] hexChars = new char[bytes.length * 2];

        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;

            hexChars[j * 2] = HEX_ARRAY[v >>> 4];

            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }

      return new String(hexChars);
    }
}