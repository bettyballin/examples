import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import javax.sql.DataSource;

public class SecurityConfiguration9 {

    private final DataSource dataSource;

    @Autowired
    public SecurityConfiguration9(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled "
                + "from terminal_user where username = ? and prop_confirmed = true")
            .authoritiesByUsernameQuery("select username, authority "
                + "from authorities where username = ?");
    }
}