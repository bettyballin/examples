import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private List<IBaseSecurityConfig> securityConfigs;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        for (IBaseSecurityConfig secConfig : securityConfigs) {
            secConfig.configure(auth);
        }
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        for (IBaseSecurityConfig secConfig : securityConfigs) {
            secConfig.configure(web);
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("CONFIGURING FROM BASE");
        for (IBaseSecurityConfig secConfig : securityConfigs) {
            secConfig.configure(http);
        }
    }
}

interface IBaseSecurityConfig {
    void configure(AuthenticationManagerBuilder auth) throws Exception;

    void configure(WebSecurity web) throws Exception;

    void configure(HttpSecurity http) throws Exception;
}