import java.math.BigInteger;
import java.util.Base64;

public class HashEncoder {
    public static void main(String[] args) {
        byte[] digest = new byte[]{ /* example digest */ };
        String hashtext = new BigInteger(1, digest).toString(16);
        String eightCharHash = hashtext.length() > 8 ? hashtext.substring(0, 8) : hashtext;
        String base64Encoded = Base64.getEncoder().encodeToString(digest);
        
        System.out.println("8-char hash: " + eightCharHash);
        System.out.println("Base64 Encoded: " + base64Encoded);
    }
}