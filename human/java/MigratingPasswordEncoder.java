import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MigratingPasswordEncoder implements PasswordEncoder {

    @Autowired
    private PasswordEncoder passwordEncoder; // new encoder (BCrypt)

    @Autowired
    private Md5PasswordEncoder legacyEncoder;

    @Autowired
    private UserDao userDao; // where password hashes are stored

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (legacyEncoder.isPasswordValid(encodedPassword, rawPassword.toString(), null)) {
            // MD5 hash found here, save a new hash instead
            userDao.updatePassword(encodedPassword, passwordEncoder.encode(rawPassword));
            return true;
        }
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}