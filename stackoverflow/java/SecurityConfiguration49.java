import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration49 extends WebSecurityConfigurerAdapter {

    @Value("${auth0.apiAudience}")
    private String apiAudience;
    @Value("${auth0.issuer}")
    private String issuer;

    @Autowired
    private VUserDetailsService vUserDetailsService;

    private Logger log = LoggerFactory.getLogger(SecurityConfiguration49.class);
    
    @Bean
    public VAuthenticationProvider authProvider() {
        JwkProvider jwkProvider = new JwkProviderBuilder(issuer).build();
        VAuthenticationProvider vAuthProvider = new VAuthenticationProvider(jwkProvider, issuer, apiAudience);
        return vAuthProvider;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/Test/public").permitAll()
            .antMatchers(HttpMethod.GET, "/Test/authenticated").authenticated()
            .antMatchers(HttpMethod.GET, "/admin/*").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/Test/root").hasRole("ROOT");
    }
}