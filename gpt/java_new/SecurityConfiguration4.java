import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import javax.sql.DataSource;

public class SecurityConfiguration4 {

    private final DataSource dataSource;

    @Autowired
    public SecurityConfiguration4(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from YOUR_USER_TABLE where username=?")
            .authoritiesByUsernameQuery("select username, authority from YOUR_AUTHORITY_TABLE where username=?");
    }
}