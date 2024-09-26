import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp118 {
    public static void main(String[] args) {
        String hexData = "your_hex_string_here"; // Replace with actual hex string
        byte[] data = hexStringToByteArray(hexData);
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(data, 0, data.length);
            byte[] sha1hash = md.digest();
            for(byte b : sha1hash) {
                System.out.printf("%02x", b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}