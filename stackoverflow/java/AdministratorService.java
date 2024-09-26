import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public ResponseEntity<Object> updatePassword(PasswordChangeRequest passwordRequest) {
        Administrator administrator = administratorRepository.findAdministrator();
        if (passwordEncoder.matches(passwordRequest.getOldPassword(), administrator.getPassword())) {
            String encodedPassword = passwordEncoder.encode(passwordRequest.getNewPassword());
            administrator.setPassword(encodedPassword);
            administratorRepository.updateAdministrator(administrator);
            customUserDetailsService.setPassword(encodedPassword);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

class PasswordChangeRequest {
    private String oldPassword;
    private String newPassword;

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

interface AdministratorRepository {
    Administrator findAdministrator();
    void updateAdministrator(Administrator administrator);
}

class CustomUserDetailsService {
    public void setPassword(String password) {
        // set the new password for the custom user details service
    }
}