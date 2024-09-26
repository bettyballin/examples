import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig66urerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import com.example.security.JWTAuthenticationFilter;
import com.example.security.JWTAuthorizationFilter;
import com.example.repository.AuthTokenModelRepository;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class SecurityConfig66 extends WebSecurityConfig66urerAdapter {

    private final LogoutHandler logoutHandler;
    private final LogoutSuccessHandler logoutSuccessHandler;
    private final AuthTokenModelRepository authTokenModelRepository;

    public SecurityConfig66(LogoutHandler logoutHandler, LogoutSuccessHandler logoutSuccessHandler,
                          AuthTokenModelRepository authTokenModelRepository) {
        this.logoutHandler = logoutHandler;
        this.logoutSuccessHandler = logoutSuccessHandler;
        this.authTokenModelRepository = authTokenModelRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/rest/noauth/**").permitAll()
            .antMatchers("/rest/login").permitAll()
            .antMatchers("/rest/logout").permitAll()
            .antMatchers("/src/**").permitAll()
            .antMatchers("/v2/api-docs/**", "/configuration/ui/**", "/swagger-resources/**",
                    "/configuration/security/**", "/swagger-ui.html/**", "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .logout().addLogoutHandler(logoutHandler).logoutSuccessHandler(logoutSuccessHandler)
            .logoutUrl("/rest/logout")
            .and()
            .addFilterBefore(new JWTAuthenticationFilter("/rest/login", authenticationManager()),
                    UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new JWTAuthorizationFilter(authenticationManager(), authTokenModelRepository),
                    UsernamePasswordAuthenticationFilter.class);
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}