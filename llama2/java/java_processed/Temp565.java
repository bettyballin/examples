import org.apache.commons.codec.binary.Base64;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Temp565 {

    public static void main(String[] args) {
        User user = new User("example@example.com", "password123".getBytes(StandardCharsets.UTF_8), List.of("ROLE_USER"));
        User newUser = encodePassword(user);
        System.out.println("Encoded Password: " + new String(newUser.getPassword(), StandardCharsets.UTF_8));
    }

    public static User encodePassword(User user) {
        String encodedPassword = new String(Base64.encodeBase64(user.getPassword()), StandardCharsets.UTF_8);
        return new User(user.getEmail(), encodedPassword.getBytes(StandardCharsets.UTF_8), user.getAuthorities());
    }

    static class User {
        private String email;
        private byte[] password;
        private List<String> authorities;

        public User(String email, byte[] password, List<String> authorities) {
            this.email = email;
            this.password = password;
            this.authorities = authorities;
        }

        public String getEmail() {
            return email;
        }

        public byte[] getPassword() {
            return password;
        }

        public List<String> getAuthorities() {
            return authorities;
        }
    }
}