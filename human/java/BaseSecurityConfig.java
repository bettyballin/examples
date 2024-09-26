import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public interface IBaseSecurityConfig {

    void configure(AuthenticationManagerBuilder auth) throws Exception;
    void configure(WebSecurity web) throws Exception;
    void configure(HttpSecurity http) throws Exception;

}

@Configuration
public abstract class BaseSecurityConfig extends WebSecurityConfigurerAdapter implements IBaseSecurityConfig {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Any defaults

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // TODO Any defaults

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // TODO Any defaults

    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        configure(http);
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        configure(auth);
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        configure(web);
    }
}