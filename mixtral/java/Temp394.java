import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;

public class Temp394 {
    private static DataSource dataSource;
    private static Auth auth;

    public static void main(String[] args) {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, authority from authorities where username=?")
            .passwordEncoder(new BCryptPasswordEncoder());
    }
}

class Auth {
    public JdbcAuth jdbcAuthentication() {
        return new JdbcAuth();
    }

    class JdbcAuth {
        public JdbcAuth dataSource(DataSource dataSource) {
            // Implementation here
            return this;
        }

        public JdbcAuth usersByUsernameQuery(String query) {
            // Implementation here
            return this;
        }

        public JdbcAuth authoritiesByUsernameQuery(String query) {
            // Implementation here
            return this;
        }

        public JdbcAuth passwordEncoder(BCryptPasswordEncoder encoder) {
            // Implementation here
            return this;
        }
    }
}