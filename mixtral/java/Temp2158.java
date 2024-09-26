import org.mindrot.jbcrypt.BCrypt;

public class Temp2158 {
    public static void main(String[] args) {
        String password = "yourPassword"; // Replace with the actual password you want to hash
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        // Store the hashed password in your database
        System.out.println("Hashed Password: " + hashedPassword);
    }
}