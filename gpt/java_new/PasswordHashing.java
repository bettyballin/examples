import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
    
    // Method to hash a password
    public static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
}