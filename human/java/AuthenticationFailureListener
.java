import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureListener
    implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

  @Autowired
  private UserDao userDao;

  @Override
  public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent ev) {
    String username = ev.getAuthentication().getName();
    User user = userDao.find("name", username);
    if (user != null) { // only for existing users
            user.reportLoginFailure();
            userDao.commit();
    }
  }
}

// Assuming UserDao and User are defined elsewhere
public class UserDao {

  public User find(String field, String value) {
    // Implement the logic to find a user by the field and value
    return new User(); // Placeholder return
  }

  public void commit() {
    // Implement the logic to commit changes to the database
  }
}

public class User {

  public void reportLoginFailure() {
    // Implement logic to report login failure
  }
}