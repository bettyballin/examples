import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class SecurityConfiguration46 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            // Assuming JwtUsernameAndPasswordFilter and JwtTokenVerifier are implemented correctly
            // .addFilter(new JwtUsernameAndPasswordFilter(authenticationManager()))
            // .addFilterAfter(new JwtTokenVerifier(), JwtUsernameAndPasswordFilter.class)
            .authorizeRequests()
            .antMatchers("/accountPage", "/accountSettings").authenticated()
            .antMatchers("/", "/signUp", "/logIn").permitAll()
            .anyRequest().authenticated();
    }
}