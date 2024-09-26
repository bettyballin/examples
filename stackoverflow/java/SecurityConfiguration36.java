import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import javax.sql.DataSource;

public class SecurityConfiguration36 {

    private final DataSource dataSource;

    @Autowired
    public SecurityConfiguration36(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username,password,1 from xxx where username = ?")
            .authoritiesByUsernameQuery("select username, role from xxx where username = ?");
    }
}