public class Temp832 {
    public static void main(String[] args) {
        // Assuming user and currentPassword are predefined for this example.
        User user = new User();
        user.setPassword("encryptedPassword");

        String currentPassword = "plainTextPassword";

        // Assuming _stringDigester is predefined for this example.
        StringDigester _stringDigester = new StringDigester();

        String encryptedCurrentPassword = user.getPassword();
        String encryptedInputPassword = _stringDigester.digest(currentPassword);
        if (encryptedCurrentPassword.equals(encryptedInputPassword)) {
            // Passwords match proceed with updating the new password.
            System.out.println("Passwords match, proceed with updating the new password.");
        } else {
            System.out.println("Passwords do not match.");
        }
    }
}

// Dummy User class
class User {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// Dummy StringDigester class
class StringDigester {
    public String digest(String input) {
        // Dummy implementation, in real case this should encrypt the password.
        return "encryptedPassword";
    }
}