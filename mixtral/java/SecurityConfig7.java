import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.PortMapper;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PortMapper customPortMapper() {
        return new CustomPortMapper();
    }

    // Example configuration to make it complete
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .csrf().disable();
    }

    // CustomPortMapper class for completeness
    public static class CustomPortMapper implements PortMapper {
        @Override
        public Integer lookupHttpPort(Integer httpsPort) {
            // Custom logic here
            return null;
        }

        @Override
        public Integer lookupHttpsPort(Integer httpPort) {
            // Custom logic here
            return null;
        }
    }
}