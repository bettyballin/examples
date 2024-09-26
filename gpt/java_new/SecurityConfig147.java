import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig147urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig147 extends WebSecurityConfig147urerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(
                "SELECT email, password, enabled FROM user_account WHERE email=?")
            .authoritiesByUsernameQuery(
                "SELECT email, authority FROM user_roles WHERE email=?");
    }
}