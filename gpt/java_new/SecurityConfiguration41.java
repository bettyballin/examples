import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class SecurityConfiguration41 extends WebSecurityConfigurerAdapter {

    private TokenAuthFilter tokenAuthFilter;
    private CustomAuthenticationProvider authenticationProvider;

    public SecurityConfiguration41(TokenAuthFilter tokenAuthFilter, CustomAuthenticationProvider authenticationProvider) {
        this.tokenAuthFilter = tokenAuthFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(tokenAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .authorizeRequests()
                .antMatchers("/api/v1/specific").hasRole("SPECIFIC")
                .antMatchers("/api/v1/**").hasRole("ADMIN")
                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", 
                             "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**",
                             "/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf().disable();
    }
}