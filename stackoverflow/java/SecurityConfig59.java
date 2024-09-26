import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig59urerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig59 extends WebSecurityConfig59urerAdapter {

    private String contentPath;
    private String apiKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String contentPathDir = String.format("/%s/**", contentPath);

        http.addFilterBefore(new TokenAuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class)
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeRequests()
            .antMatchers("/authorization/**", "/public/**", "/management/**", "/health/**", contentPathDir).permitAll()
            .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(apiKeyAuthenticationProvider());
    }

    @Bean
    public TokenAuthenticationProvider apiKeyAuthenticationProvider() {
        return new TokenAuthenticationProvider(apiKey);
    }
}