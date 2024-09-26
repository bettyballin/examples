import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp1511 {
    public static void main(String[] args) {
        User user = new User("{bcrypt}password123");

        if (user.getPassword().startsWith("{bcrypt}")) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String passwordWithoutPrefix = user.getPassword().substring(8);
            String encodedPassword = bCryptPasswordEncoder.encode(passwordWithoutPrefix);
            System.out.println("BCrypt Encoded Password: " + encodedPassword);
        } else if (user.getPassword().startsWith("{hmacsha512}")) {
            // Use HmacSha512PasswordEncoder for encoding and decoding
            // HmacSha512PasswordEncoder implementation is required here
            System.out.println("HmacSha512PasswordEncoder implementation is required here");
        }
    }
}

class User {
    private String password;

    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}