import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main63 {

    public static String md5EncodePassword(String password, String salt) {
        String saltedPassword = password + "{" + salt + "}";
        StringBuilder hexString = new StringBuilder();

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(saltedPassword.getBytes());
            byte[] hash = digest.digest();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hexString.toString();
    }

    public static void main(String[] args) {
        String password = "1";
        String salt = "1";
        System.out.println(md5EncodePassword(password, salt));
    }
}