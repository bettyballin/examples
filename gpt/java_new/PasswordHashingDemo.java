import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashingDemo {
    public static void main(String[] args) {
        String plainTextPassword = "mySecretPassword";
        String salt = BCrypt.gensalt();
        
        // Generate a salt and hash the password
        String hashedPassword = BCrypt.hashpw(plainTextPassword, salt);

        System.out.println("Hashed password: " + hashedPassword);

        // Check a password against the stored hash
        boolean passwordVerified = BCrypt.checkpw(plainTextPassword, hashedPassword);

        System.out.println("Password verified: " + passwordVerified);
    }
}