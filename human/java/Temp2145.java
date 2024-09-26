import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp2145 {

    private AdministratorRepository administratorRepository;
    private PasswordEncoder passwordEncoder;

    public Temp2145(AdministratorRepository administratorRepository, PasswordEncoder passwordEncoder) {
        this.administratorRepository = administratorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        // Example usage
        AdministratorRepository administratorRepository = new AdministratorRepository();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Temp2145 temp2145 = new Temp2145(administratorRepository, passwordEncoder);

        Password password = new Password("oldPassword", "newPassword");
        ResponseEntity response = temp2145.updatePassword(password);
        System.out.println(response.getStatusCode());
    }

    public ResponseEntity updatePassword(Password password) {
        Administrator administrator = administratorRepository.findAdministrator();
        if (passwordEncoder.matches(password.getOldPassword(), administrator.getPassword())) {
            String encodePassword = passwordEncoder.encode(password.getNewPassword());
            administrator.setPassword(encodePassword);
            administratorRepository.updateAdministrator(administrator);
            CustomUserDetailsService.password = encodePassword;
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}

class Password {
    private String oldPassword;
    private String newPassword;

    public Password(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}

class Administrator {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class AdministratorRepository {
    public Administrator findAdministrator() {
        // Mock implementation
        Administrator administrator = new Administrator();
        administrator.setPassword("$2a$10$DowJNGl.gP2l8jZg4qH7xu0e7GJz5GzR1mJZl8e3gE7e5Hq8z4P7S"); // encoded "oldPassword"
        return administrator;
    }

    public void updateAdministrator(Administrator administrator) {
        // Mock implementation
        System.out.println("Administrator updated with new password: " + administrator.getPassword());
    }
}

class CustomUserDetailsService {
    public static String password;
}

class BCryptPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        // Mock implementation
        return "$2a$10$DowJNGl.gP2l8jZg4qH7xu" + rawPassword;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Mock implementation
        return encodedPassword.equals("$2a$10$DowJNGl.gP2l8jZg4qH7xu" + rawPassword);
    }
}