import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
@EnableWebSecurity
public class SecurityConfig219 {
    // Other security configuration methods here

    @Bean
    public Converter<Authentication, ?> authenticationConverter() {
        return new Converter<Authentication, SimpleGrantedAuthority>() {
            @Override
            public SimpleGrantedAuthority convert(Authentication authentication) {
                // Custom conversion logic here
                return new SimpleGrantedAuthority("ROLE_USER");
            }
        };
    }
    
    protected void configure(HttpSecurity http) throws Exception {
        // HttpSecurity configuration logic here
    }
}