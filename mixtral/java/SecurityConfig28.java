import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;

@Configuration
public class SecurityConfig {
    public String readRole = "Domain Users";

    @Bean
    public SecurityConfig securityConfig() {
        return new SecurityConfig();
    }
}

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority(@securityConfig.readRole)")
public @interface UserCanSeeRestricted { }