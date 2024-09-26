import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.http.HttpMethod;

@EnableWebSecurity
public class ResourceServerConfiguration1 extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.PUT, "/api/*/action/*")
            .access("hasAnyAuthority('ROLE_View_account','ROLE_Search_account')")
            .anyRequest().authenticated();
    }
}