import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CustomLogoutHandler implements LogoutHandler {
    private PersistentTokenRepository tokenRepository;

    public CustomLogoutHandler(PersistentTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
            List<PersistentLogin> persistentLogins = tokenRepository.findByUsername(username);

            for (PersistentLogin login : persistentLogins) {
                // Only delete the current session's remember-me cookie
                if (!login.getSeries().equals(request.getSession(false) != null ? request.getSession(false).getId() : null)) {
                    continue;
                }
                tokenRepository.delete(login);
            }
        }
    }

    // Mock classes for PersistentTokenRepository and PersistentLogin for demonstration
    interface PersistentTokenRepository {
        List<PersistentLogin> findByUsername(String username);
        void delete(PersistentLogin login);
    }

    static class PersistentLogin {
        private String series;

        public String getSeries() {
            return series;
        }
    }
}