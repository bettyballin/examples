import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessListener1 implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        Authentication authentication = event.getAuthentication();
        String message = "User " + authentication.getName() + " logged in";
        kafkaTemplate.send("login-topic", message);
    }
}