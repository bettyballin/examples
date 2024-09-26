import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Temp3317 {
    public static void main(String[] args) {
        byte[] passwordb = "password".getBytes(StandardCharsets.UTF_8);
        String hashed = hashpw(passwordb, null);
        System.out.println(checkpw(passwordb, hashed));
    }

    /**
     * Check that a password (as a byte array) matches a previously hashed one
     * 
     * @param passwordb the password to verify, as a byte array
     * @param hashed    the previously-hashed password
     * @return true if the passwords match, false otherwise
     * @since 5.3
     */
    public static boolean checkpw(byte[] passwordb, String hashed) {
        return equalsNoEarlyReturn(hashed, hashpw(passwordb, hashed));
    }

    public static String hashpw(byte[] passwordb, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            if (salt != null) {
                md.update(salt.getBytes(StandardCharsets.UTF_8));
            }
            byte[] hashedBytes = md.digest(passwordb);
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean equalsNoEarlyReturn(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result |= a.charAt(i) ^ b.charAt(i);
        }
        return result == 0;
    }
}