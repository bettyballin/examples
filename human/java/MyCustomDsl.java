import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import javax.servlet.Filter;
import org.springframework.security.authentication.AuthenticationManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable();
        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
            .authorizeRequests()
            .antMatchers("/error").permitAll();
        http
            .authorizeRequests()
            .antMatchers("/api/login/**", "/api/token/refresh/**").permitAll();
        http
            .authorizeRequests()
            .anyRequest().authenticated();
        // apply the custom DSL which adds the custom filter
        http
            .apply(customDsl());
        http
            .addFilterBefore(new CustomAuthorizationFilter(jwtSecret), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    public static class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            AuthenticationManager authenticationManager =
                    http.getSharedObject(AuthenticationManager.class);
            CustomAuthenticationFilter filter = 
                    new CustomAuthenticationFilter(authenticationManager, accessTokenExpiredInDays, refreshTokenExpiredInDays, jwtSecret);
            filter.setFilterProcessesUrl("/api/login");
            http.addFilter(filter);
        }

        public static MyCustomDsl customDsl() {
            return new MyCustomDsl();
        }
    }

    // Define your CustomAuthorizationFilter and CustomAuthenticationFilter classes here
    // Define accessTokenExpiredInDays, refreshTokenExpiredInDays, jwtSecret variables here
}