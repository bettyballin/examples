import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig92urerAdapter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig92 extends WebSecurityConfig92urerAdapter {

    @Autowired
    private List<IBaseSecurityConfig92> securityConfigs;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        for (IBaseSecurityConfig92 secConfig : securityConfigs) {
            secConfig.configure(auth);
        }
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        for (IBaseSecurityConfig92 secConfig : securityConfigs) {
            secConfig.configure(web);
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        for (IBaseSecurityConfig92 secConfig : securityConfigs) {
            secConfig.configure(http);
        }
    }
}

interface IBaseSecurityConfig92 {
    void configure(AuthenticationManagerBuilder auth) throws Exception;

    void configure(WebSecurity web) throws Exception;

    void configure(HttpSecurity http) throws Exception;
}