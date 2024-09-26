import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Temp1344 {
    public static Map<String, String> users = new HashMap<>();

    static {
        // Add your username and hashed password
        users.put("username", createHash("password", null));
    }

    // Method for checking the validity of a given user/pass combination
    public boolean checkUser(String name, String pass) throws Exception {
        if (users.containsKey(name)) {
            return Arrays.equals(createHash(pass, null).getBytes(), users.get(name).getBytes());
        }
        return false;
    }

    // Method to create a hash from a password
    public static String createHash(String password, Object salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            Temp1344 temp = new Temp1344();
            System.out.println(temp.checkUser("username", "password")); // should return true
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}