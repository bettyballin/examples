import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp335 {
    public static void main(String[] args) {
        try {
            String input = "example"; 
            byte[] bytes = input.getBytes("UTF-8"); 

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(bytes);

            StringBuilder hexString = new StringBuilder();
            for (byte b : md5Bytes) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println("MD5 hash: " + hexString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}