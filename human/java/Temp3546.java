import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Temp3546 {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        // Example usage
        Temp3546 service = new Temp3546();
        UserDto userDto = new UserDto("John", "Doe", "john.doe@example.com", "password123");
        try {
            User user = service.registerNewUserAccount(userDto);
            System.out.println("User registered: " + user.getEmail());
        } catch (EmailExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                "There is an account with that email address: " + accountDto.getEmail());
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        
        // Encoding user's password:
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        
        user.setEmail(accountDto.getEmail());
        user.setRole(new Role(Integer.valueOf(1), user));
        return repository.save(user);
    }

    private boolean emailExist(String email) {
        // This should be implemented to check if the email already exists in the repository
        return repository.findByEmail(email) != null;
    }
}

// Assume User, UserDto, Role, UserRepository, and EmailExistsException classes are defined elsewhere
class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

    // Getters and setters

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}

class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters and setters

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class Role {
    private Integer id;
    private User user;

    public Role(Integer id, User user) {
        this.id = id;
        this.user = user;
    }

    // Getters and setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

interface UserRepository {
    User save(User user);
    User findByEmail(String email);
}

class EmailExistsException extends Exception {
    public EmailExistsException(String message) {
        super(message);
    }
}