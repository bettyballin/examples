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

public class Temp373 {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        // You need to initialize the ApplicationContext and HttpSession here.
    }

    public static void authenticateSession(HttpSession session, UserDetails user) {
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword());
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                user, authRequest.getCredentials(), user.getAuthorities());
        result.setDetails(authRequest.getDetails());

        SecurityContext ctx = SecurityContextHolder.createEmptyContext();
        ctx.setAuthentication(result);

        session.setAttribute(
                UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY,
                TextEscapeUtils.escapeEntities(user.getUsername()));
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                ctx);

        AuthenticationSuccessEvent event = new AuthenticationSuccessEvent(
                result);
        applicationContext.publishEvent(event);
    }
}