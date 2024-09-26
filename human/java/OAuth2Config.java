import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class OAuth2Config extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.addFilterAfter(myFilter(), BasicAuthenticationFilter.class);
    }

    public MyFilter myFilter() {
        return new MyFilter();
    }

    public class MyFilter extends BasicAuthenticationFilter {
        // Implement your filter logic here
    }
}