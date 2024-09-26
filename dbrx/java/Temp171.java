import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp171 {
    public static void main(String[] args) {
        try {
            String originalPassword = "user_input_password";
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(originalPassword.getBytes("UTF-8"));
            
            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            System.out.println("Original Password: " + originalPassword);
            System.out.println("MD5 Hash: " + hexString.toString());
            
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}