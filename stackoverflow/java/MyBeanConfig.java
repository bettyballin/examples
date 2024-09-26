import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.stereotype.Component;

@Component
public class MyBeanConfig {

    @Bean
    public ApplicationListener<AbstractAuthenticationEvent> authenticationListener() {
        return new MyAuthenticationListener();
    }

    private static class MyAuthenticationListener implements ApplicationListener<AbstractAuthenticationEvent> {
        @Override
        public void onApplicationEvent(AbstractAuthenticationEvent event) {
            // handle the authentication event
        }
    }
}