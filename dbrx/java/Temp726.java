import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), BasicAuthenticationFilter.class)
            .requestMatcher(new NegatedRequestMatcher(
                new AntPathRequestMatcher("/some_endpoint")
            ));
    }

    public UsernamePasswordAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new UsernamePasswordAuthenticationFilter();
    }
}