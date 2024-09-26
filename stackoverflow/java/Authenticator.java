import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.util.TextEscapeUtils;

import javax.servlet.http.HttpSession;

public class Authenticator {

    private ApplicationContext applicationContext;

    public Authenticator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void authenticateSession(HttpSession session, UserDetails user) {
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword(), user.getAuthorities());

        SecurityContext ctx = SecurityContextHolder.createEmptyContext();
        ctx.setAuthentication(authRequest);

        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                ctx);

        AuthenticationSuccessEvent event = new AuthenticationSuccessEvent(authRequest);
        applicationContext.publishEvent(event);
    }
}