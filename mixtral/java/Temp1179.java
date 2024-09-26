public class Temp1179 {
    public static void main(String[] args) {
        User user = new User();
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        user.setEncodedPassword(passwordEncoder.encode("new_plaintext_password"));
    }
}

class User {
    private String encodedPassword;

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }
}

class PasswordEncoder {
    public String encode(String plaintextPassword) {
        // A simple encoding example (not secure for real use cases)
        return new StringBuilder(plaintextPassword).reverse().toString();
    }
}