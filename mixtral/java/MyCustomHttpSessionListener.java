import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MyCustomHttpSessionListener implements HttpSessionListener {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;

    public void sessionCreated(HttpSessionEvent se) {}

    public void sessionDestroyed(HttpSessionEvent se) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && !authenticationTrustResolver.isAnonymous(authentication)) {
            MySessionBean mySessionBean = applicationContext.getBean(MySessionBean.class);

            // Call the cleanup logic in your session-scoped bean
            mySessionBean.cleanup();
        }
    }
}

interface AuthenticationTrustResolver {
    boolean isAnonymous(Authentication authentication);
}

@Component
class MySessionBean {
    public void cleanup() {
        // Your cleanup logic here
    }
}