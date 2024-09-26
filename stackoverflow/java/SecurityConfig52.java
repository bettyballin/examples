import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig52urerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig52 extends WebSecurityConfig52urerAdapter {

    @Autowired
    TosFilter rolesFilter;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .addFilterAfter(rolesFilter, AbstractPreAuthenticatedProcessingFilter.class)
                .csrf().disable()
                .authorizeRequests().anyRequest().permitAll();
    }

    // Assuming TosFilter is a valid Filter class
    public class TosFilter extends SomeFilterClass {
        // Filter implementation
    }
}