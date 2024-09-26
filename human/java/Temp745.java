import org.apache.commons.codec.digest.DigestUtils;

public class Temp745 {
    public static void main(String[] args) {
        String id = "example"; // Example input string

        // Generate MD5 hex string
        String md5Hex = DigestUtils.md5Hex(id);
        System.out.println("MD5 Hex: " + md5Hex);

        // Generate MD5 byte array
        byte[] md5Bytes = DigestUtils.md5(id);
        System.out.print("MD5 Bytes: ");
        for (byte b : md5Bytes) {
            System.out.printf("%02x", b);
        }
    }
}