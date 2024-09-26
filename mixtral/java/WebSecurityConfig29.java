import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyResourceServerConfig resourceServer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        resourceServer.configure(http);
    }

}

// Your custom configuration
class MyResourceServerConfig {

    public void configure(HttpSecurity http) throws Exception {
        // your security configurations here
    }

}