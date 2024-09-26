import org.mindrot.jbcrypt.BCrypt;

public class Temp169 {
    public static void main(String[] args) {
        String password = "myPassword123";
        String inputtedPassword = "myPassword123";
        
        // Generate hashed password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // Check if inputted password is valid
        boolean isValid = BCrypt.checkpw(inputtedPassword, hashedPassword);

        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Is Valid: " + isValid);
    }
}