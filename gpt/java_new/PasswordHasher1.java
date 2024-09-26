import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher1 {
    public static void main(String[] args) {
        // Hash a password
        String password = "myPassword123";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        
        // Output the hashed password (this would typically be where you store 'hashed' in your database)
        System.out.println(hashed);
    }
}