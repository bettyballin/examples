import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Service
public class EnvironmentService {
    public String getRequiredAuthority() {
        return "Domain Users";
    }
}

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Your configuration here
}

@Retention(RetentionPolicy.RUNTIME)
@Target({}) // Specify the correct target, e.g., ElementType.METHOD, ElementType.TYPE, etc.
@interface CustomAnnotation {
    // Define annotation elements here
}