import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1HexExample {

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }

    public static String sha1Hex(String input) {
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA-1");
            byte[] result = mDigest.digest(input.getBytes());
            return byteArrayToHex(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String originalString = "example";
        String sha1Hex = sha1Hex(originalString);
        System.out.println(sha1Hex);
    }
}