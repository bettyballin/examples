import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.config.annotation.web.configuration.ResourceServerConfig2urerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.http.HttpMethod;

@Configuration
@EnableResourceServer
public class ResourceServerConfig2 extends ResourceServerConfig2urerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new OrRequestMatcher(
                new AntPathRequestMatcher("/**"),
                new RequestHeaderRequestMatcher("Authorization")
            ))
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/beers").permitAll()
            .anyRequest().authenticated();
    }
}