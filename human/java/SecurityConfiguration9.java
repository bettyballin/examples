import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    
    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Autowired
    VUserDetailsService vUserDetailsService;

    Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);
    
    @Bean
    public VAuthenticationProvider authProvider() {
        JwkProvider jwkProvider = new JwkProviderBuilder(issuer).build(); //Auth0 provided class
        VAuthenticationProvider vAuthProvider = new VAuthenticationProvider(jwkProvider, issuer, apiAudience);
        return vAuthProvider;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        JwtWebSecurityConfigurer.forRS256(apiAudience, issuer, authProvider())
                .configure(http)
                .authorizeRequests().antMatchers(HttpMethod.GET, "/Test/public").permitAll()
                .antMatchers(HttpMethod.GET, "/Test/authenticated").authenticated()
                .antMatchers(HttpMethod.GET, "/admin/*").hasRole("ADMIN") //Not Auth0 role, defined in my DB.
                .antMatchers(HttpMethod.GET, "/Test/root").hasRole("ROOT"); //Not Auth0 role, defined in my DB.
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    /* Additional code omitted */
}

// Assuming VUserDetailsService and VAuthenticationProvider are defined elsewhere.