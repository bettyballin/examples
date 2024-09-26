import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig13urerAdapter;
import org.springframework.security.saml.SAMLAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig13 extends WebSecurityConfig13urerAdapter {

    @Autowired
    @Qualifier("samlAuthenticationProvider")
    private SAMLAuthenticationProvider samlAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your HttpSecurity configuration
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(samlAuthenticationProvider);
    }

    @Bean(name = "myAuthenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}