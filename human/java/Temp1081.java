import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp1081 {
    public static void main(String[] args) {
        String tmpSessionId = "exampleSessionId"; // Added a value for tmpSessionId
        byte[] input = null;
        try {
            input = new String("X-Session-Id" + tmpSessionId + "test").getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            System.out.println("Unsupported encoding exception");
            e.printStackTrace();
        }

        MessageDigest messageDigest;
        byte[] output = new byte[32]; // since SHA256 hash is 256 bits = 32 bytes
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(input, 0, input.length);
            messageDigest.digest(output, 0, 32); // same
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DigestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Print the result
        System.out.println(bytesToHex(output));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}