import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class LoginAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserDetailsDao userDetailsDao;

    public LoginAuthenticationSuccessHandler(UserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }
}