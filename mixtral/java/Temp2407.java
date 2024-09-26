import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2407 {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Simulated login and repository
        Login login = new Login();
        login.setUsername("user");
        login.setPassword("password");

        UserRepository userRepository = new UserRepository();
        userRepository.saveUser(login.getUsername(), encoder.encode(login.getPassword()));

        boolean matches = encoder.matches(
            login.getPassword(),
            userRepository.findPasswordByUsername(login.getUsername())
        );

        System.out.println("Password matches: " + matches);
        // continue your reactive pipeline here
    }
}

class Login {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class UserRepository {
    private Map<String, String> userDatabase = new HashMap<>();

    public void saveUser(String username, String encodedPassword) {
        userDatabase.put(username, encodedPassword);
    }

    public String findPasswordByUsername(String username) {
        return userDatabase.get(username);
    }
}


Make sure you have the necessary dependencies for `BCryptPasswordEncoder` by including Spring Security in your project. For example, in Maven you would add:

xml
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-core</artifactId>
    <version>5.5.3</version>
</dependency>