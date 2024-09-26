import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class HashExample {
    public static void main(String[] args) {
        String login = JOptionPane.showInputDialog("Login : ");
        String password = JOptionPane.showInputDialog("Password : ");

        try { 
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(login.getBytes());
            m.update(password.getBytes());
            byte[] digest = m.digest();
            
            BigInteger bigInt = new BigInteger(1, digest);
            String hashtext = bigInt.toString(16);
            while(hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }
            
            JOptionPane.showMessageDialog(null, "Hashed: " + hashtext);
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}