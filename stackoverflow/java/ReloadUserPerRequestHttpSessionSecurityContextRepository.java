import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class ReloadUserPerRequestHttpSessionSecurityContextRepository extends HttpSessionSecurityContextRepository {

    private UserRepository userRepository;

    public ReloadUserPerRequestHttpSessionSecurityContextRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        SecurityContext context = super.loadContext(requestResponseHolder);
        Authentication authentication = context.getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            UserDetails newUserDetails = userRepository.findByUsername(userDetails.getUsername());
            Authentication newAuthentication = new UsernamePasswordAuthenticationToken(newUserDetails, authentication.getCredentials(), newUserDetails.getAuthorities());
            context.setAuthentication(newAuthentication);
        }
        return context;
    }
}