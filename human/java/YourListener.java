import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

public class YourListener implements ApplicationListener<HttpSessionDestroyedEvent> {

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent evt) {
        for (SecurityContext ctx : evt.getSecurityContexts()) {
            Authentication auth = ctx.getAuthentication();
            if (auth != null) {
                Object principal = auth.getPrincipal();
                // Do your thing with the principal.
            }
        }
    }
}