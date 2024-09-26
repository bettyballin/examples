import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private UserDao userDao;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();
        User user = userDao.find("name", username);
        user.reportLoginOK();
        userDao.commit();
    }
}

// Assuming UserDao and User classes are defined as follows:

public interface UserDao {
    User find(String field, String value);
    void commit();
}

public class User {
    public void reportLoginOK() {
        // Implementation of reportLoginOK
    }
}