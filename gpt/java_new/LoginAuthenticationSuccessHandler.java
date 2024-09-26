import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Component
public class LoginAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserDetailsDao userDetailsDao;

    @Autowired
    public LoginAuthenticationSuccessHandler(UserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }

    // ...
}