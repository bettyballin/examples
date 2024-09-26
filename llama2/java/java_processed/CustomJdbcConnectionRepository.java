import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.jdbc.JdbcConnectionRepository;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CustomJdbcConnectionRepository extends JdbcConnectionRepository {

    private boolean connectionSignUp;

    @Autowired
    public CustomJdbcConnectionRepository(DataSource dataSource,
                                          JdbcTemplate jdbcTemplate,
                                          UserDetailsService userDetailsService) {
        super(dataSource, jdbcTemplate, userDetailsService);
    }

    @Override
    public void setConnectionSignUp(boolean connectionSignUp) {
        this.connectionSignUp = connectionSignUp;
    }

    @Override
    protected org.springframework.security.oauth2.common.OAuth2AccessToken.Connection getConnection(String username, String password) {
        // Implement your custom logic to create a connection
        // ...
        return super.getConnection(username, password);
    }
}