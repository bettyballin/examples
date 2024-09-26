import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/account/**")
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin();

        http.csrf().disable();

        http
            .exceptionHandling()
                .defaultAuthenticationEntryPointFor(authenticationEntryPoint, new AntPathRequestMatcher("/account/**"));
    }
}