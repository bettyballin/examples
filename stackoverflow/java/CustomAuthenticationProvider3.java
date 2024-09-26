import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.stream.Collectors;

public class CustomAuthenticationProvider3 {
    private UserRepository userRepo;
    private RightRepository rightRepo;
    private PasswordEncoder encoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        User user = userRepo.findOneByUsername(username).orElseThrow(() -> new BadCredentialsException("1000"));
        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("1000");
        }
        if (user.isDisabled()) {
            throw new DisabledException("1001");
        }
        List<Right> userRights = rightRepo.getUserRights(username);
        return new UsernamePasswordAuthenticationToken(username, null, userRights.stream().map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList()));
    }

    // setters for userRepo, rightRepo, and encoder or constructor
}