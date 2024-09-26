import org.mindrot.jbcrypt.BCrypt;

public class Temp1629 {
    public static void main(String[] args) {
        String password = "myPassword123";
        String hashedPassword = hashPassword(password);
        
        System.out.println("Password: " + password);
        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Password Match: " + checkPassword(password, hashedPassword));
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}