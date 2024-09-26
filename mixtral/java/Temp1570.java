import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService currentUser() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                // Implement your logic to load user by username
                return new org.springframework.security.core.userdetails.User(
                        "user", "password", new ArrayList<>()
                );
            }
        };
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(currentUser());
    }
}

@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {
    Class<?> value() default UserDetails.class;
}