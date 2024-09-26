import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String SIGN_UP_URL = "/signup";
    private static final String UPVOTE_URL = "/upvote";
    private static final String DOWNVOTE_URL = "/downvote";
    private static final String LOG_OUT_URL = "/logout";
    private static final String DELETE_URL = "/delete";
    private static final String ADD_URL = "/add";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
                .and()
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.GET, "/").authenticated()
                .antMatchers(HttpMethod.GET, UPVOTE_URL).authenticated()
                .antMatchers(HttpMethod.GET, DOWNVOTE_URL).authenticated()
                .antMatchers(HttpMethod.POST, LOG_OUT_URL).authenticated()
                .antMatchers(HttpMethod.DELETE, DELETE_URL).authenticated()
                .antMatchers(HttpMethod.POST, ADD_URL).authenticated()
                .anyRequest().authenticated()
                .and()
            .addFilterBefore(new JWTAuthenticationFilter(authenticationManager()), HeaderWriterFilter.class)
            .addFilterAfter(new JWTAuthorizationFilter(authenticationManager()), JWTAuthenticationFilter.class)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .formLogin()
                .and()
            .logout();
    }
}