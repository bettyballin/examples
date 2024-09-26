import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig114urerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.savedrequest.NullRequestCache;

public class SecurityConfig114 extends WebSecurityConfig114urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/user/create").authenticated()
                .antMatchers("/user/login").authenticated()
                .anyRequest().permitAll()
                .and()
            .requestCache()
                .requestCache(new NullRequestCache())
                .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .httpBasic()
                .authenticationEntryPoint(new BasicAuthenticationEntryPoint())
                .and()
            .addFilterBefore(yourXAuthTokenFilter(), BasicAuthenticationFilter.class);
    }
    
    // Dummy implementation of yourXAuthTokenFilter to satisfy code compilation
    private BasicAuthenticationFilter yourXAuthTokenFilter() {
        return new BasicAuthenticationFilter(authenticationManager());
    }
}