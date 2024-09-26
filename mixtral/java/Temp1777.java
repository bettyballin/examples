public class Temp1777 {
    public static void main(String[] args) {

        // Dummy PasswordEncoder and User classes for demonstration purposes
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        User editUser = new User("password123");
        User user = new User("password123");

        if (passwordEncoder.matches(editUser.getPassword_1(), user.getPassword())) {
            // Passwords match
            System.out.println("Passwords match");
        } else {
            // Password mismatch
            System.out.println("Password mismatch");
        }
    }
}

class PasswordEncoder {
    public boolean matches(String rawPassword, String encodedPassword) {
        // Simple comparison for demonstration (in real scenarios, use proper encoding)
        return rawPassword.equals(encodedPassword);
    }
}

class User {
    private String password;

    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPassword_1() {
        return this.password;
    }
}