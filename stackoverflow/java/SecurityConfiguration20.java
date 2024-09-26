import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfiguration20 {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // ... configure it ...
    }
}