import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Temp447 {
    public static void main(String[] args) {

        String publicKey = "yourPublicKeyHere"; // Replace with your actual public key

        String fingerprint = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] keyBytes = Base64.getDecoder().decode(publicKey);
            digest.update(keyBytes, 0, keyBytes.length);
            fingerprint = toHexString(digest.digest());
            System.out.println("Fingerprint: " + fingerprint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}