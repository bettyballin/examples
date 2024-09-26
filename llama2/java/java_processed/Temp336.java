import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

public class Temp336 {
    public static void main(String[] args) {

        String login;
        String password;

        login = "my_login"; // Replace with actual user input
        password = "my_password"; // Replace with actual user input

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] loginBytes = login.getBytes("UTF-8");
            byte[] passwordBytes = password.getBytes("UTF-8");

            md.update(loginBytes);
            md.update(passwordBytes);

            byte[] hash = md.digest();

            String loginHash = toHexString(hash);
            String passwordHash = toHexString(hash);

            System.out.println("Login Hash: " + loginHash);
            System.out.println("Password Hash: " + passwordHash);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static String toHexString(byte[] bytes) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}