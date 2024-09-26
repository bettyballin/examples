import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp176 {
    public static void main(String[] args) {
        String plainText = "example";
        String shortHash = convertToMD5Hash(plainText).substring(0, 8);
        System.out.println("Short MD5 Hash: " + shortHash);
    }

    public static String convertToMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}