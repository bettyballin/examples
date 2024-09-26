import org.mindrot.jbcrypt.BCrypt;

public class Temp2159 {
    public static void main(String[] args) {
        String inputPassword = "userInputPassword"; // replace with actual input
        String storedHashedPassword = "$2a$10$DowJonesIndustrialAverage"; // replace with actual hashed password

        boolean isValid = BCrypt.checkpw(inputPassword, storedHashedPassword);
        if (isValid) {
            // Authentication successful
            System.out.println("Authentication successful");
        } else {
            // Invalid credentials
            System.out.println("Invalid credentials");
        }
    }
}