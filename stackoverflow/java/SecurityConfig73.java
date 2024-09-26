import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationEntryPoint;

public class SecurityConfig73 {

    private AuthenticationEntryPoint consoleAuthenticationEntryPoint;

    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/console/**")
            .httpBasic().and()
            .exceptionHandling().authenticationEntryPoint(consoleAuthenticationEntryPoint).and()
            .authorizeRequests().antMatchers("/console/**").authenticated()
            .antMatchers(HttpMethod.GET,
                    "/*.html",
                    "/favicon.ico",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js").permitAll()
            .anyRequest().authenticated().and()
            .formLogin().defaultSuccessUrl("/console/home")
            .loginPage("/console/login").permitAll().and()
            .logout().permitAll().and()
            .csrf().disable();
    }
}