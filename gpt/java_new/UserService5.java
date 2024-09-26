import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import your.package.User;
import your.package.UserRepository;
import your.package.PasswordUtils;

@Service
public class UserService5 {

    private final PasswordUtils passwordUtils;
    private final UserRepository userRepository;

    @Autowired
    public UserService5(PasswordUtils passwordUtils, UserRepository userRepository) {
        this.passwordUtils = passwordUtils;
        this.userRepository = userRepository;
    }

    public boolean checkOldPassword(User user, String oldPassword) {
        String encryptedOldPassword = passwordUtils.encryptUserPassword(oldPassword);
        return encryptedOldPassword.equals(user.getPassword());
    }
}