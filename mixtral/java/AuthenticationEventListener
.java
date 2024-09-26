import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener
  implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(
      InteractiveAuthenticationSuccessEvent event)
    {
        // Set up the security context here

        SecurityContextHolder.getContext()
          .setAuthentication((Authentication)event.getSource());

    }
}