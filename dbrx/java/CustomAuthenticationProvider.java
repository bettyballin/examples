import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final String username;
    private final String password;

    @Autowired
    public CustomAuthenticationProvider(@Value("${custom.username}") String username, 
                                        @Value("${custom.password}") String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        String pwd = (String) authentication.getCredentials();

        if (username.equals(name) && password.equals(pwd)) {
            return new UsernamePasswordAuthenticationToken(
                    name, null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}

Note: Make sure you have `@Value` annotations correctly configured to inject the values for `username` and `password` from your application properties file (e.g., `application.properties` or `application.yml`). If not, you can hardcode the values for testing purposes.