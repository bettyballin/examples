import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp744 {
    public static void main(String[] args) {
        try {
            String login = "exampleLogin";
            String password = "examplePassword";
            
            MessageDigest mdLogin = MessageDigest.getInstance("MD5");
            mdLogin.update(login.getBytes(), 0, login.length());
            BigInteger login1 = new BigInteger(1, mdLogin.digest());
            String hashedLogin = String.format("%1$032X", login1);
            
            MessageDigest mdPassword = MessageDigest.getInstance("MD5");
            mdPassword.update(password.getBytes(), 0, password.length());
            BigInteger password1 = new BigInteger(1, mdPassword.digest());
            String hashedPassword = String.format("%1$032X", password1);
            
            System.out.println("Hashed Login: " + hashedLogin);
            System.out.println("Hashed Password: " + hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}