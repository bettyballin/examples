import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Temp1572 {
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", 
             message = "Password should contain one letter, one digit, and one special character.")
    private String password;

    public static void main(String[] args) {
        // Example usage (You can add functionality to set and validate the password here)
    }
}