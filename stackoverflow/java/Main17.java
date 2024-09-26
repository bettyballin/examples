import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

public class Main17 {
    public static void main(String[] args) throws Exception {
        String message = "[1312701386,transactioncreate,[account_code:ABC,amount_in_cents:5000,currency:USD]]";
        String privateKey = "0123456789ABCDEF0123456789ABCDEF";

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] keyBytes = md.digest(privateKey.getBytes("UTF-8"));

        SecretKey sk = new SecretKeySpec(keyBytes, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(sk);
        byte[] result = mac.doFinal(message.getBytes("ASCII"));

        System.out.println("  Message: " + message);
        System.out.println("      Key: " + privateKey + "
");
        System.out.println("Key Bytes: " + toHex(keyBytes));
        System.out.println("  Results: " + toHex(result));
    }

    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}