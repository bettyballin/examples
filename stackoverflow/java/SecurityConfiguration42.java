import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;

public class SecurityConfiguration42 {

    private DataSource dataSource;
    private String usernameQuery;
    private String authoritiesQuery;

    public SecurityConfiguration42(DataSource dataSource, String usernameQuery, String authoritiesQuery) {
        this.dataSource = dataSource;
        this.usernameQuery = usernameQuery;
        this.authoritiesQuery = authoritiesQuery;
    }

    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery(usernameQuery)
                .authoritiesByUsernameQuery(authoritiesQuery);
    }
}