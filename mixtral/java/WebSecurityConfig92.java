import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/httpbasic/**").authenticated().and()
                    .httpBasic();

        http
            .requestMatcher(new OAuth2RequestedMatcher())
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .oauth2Login();

        http
            .exceptionHandling()
                .defaultAuthenticationEntryPointFor(customAuthenticationEntryPoint, new AntPathRequestMatcher("/api/httpbasic/**"));
    }
}

class OAuth2RequestedMatcher extends AntPathRequestMatcher {
    public OAuth2RequestedMatcher() {
        super("/oauth2/**");
    }
}

class CustomAuthenticationEntryPoint extends Http403ForbiddenEntryPoint {
    // Custom implementation
}