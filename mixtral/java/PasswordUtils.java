import org.jasypt.digest.PooledStringDigester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("passwordUtil")
public class PasswordUtils {

    @Autowired
    private PooledStringDigester _stringDigester;

    public String encryptUserPassword(String originalPassword, byte[] salt) {
        return _stringDigester.digestWithSalt(originalPassword, salt);
    }
    
    public boolean isOldPasswordCorrect(String oldPassword, String encodedOldPassword) {
        return _stringDigester.matches(oldPassword, encodedOldPassword);
    }
}