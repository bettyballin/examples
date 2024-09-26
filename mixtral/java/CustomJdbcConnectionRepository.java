import javax.sql.DataSource;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;

public class CustomJdbcConnectionRepository extends JdbcUsersConnectionRepository {

    public CustomJdbcConnectionRepository(DataSource dataSource, TextEncryptor encryptor) {
        super(dataSource, encryptor);

        // Set connectionSignUp property
        setConnectionSignUp(new ImplicitConnectionSignUp());

        afterPropertiesSet();
    }

    private static class ImplicitConnectionSignUp implements ConnectionSignUp {
        @Override
        public String execute(Connection<?> connection) {
            // Implement logic to create a user profile based on the connection
            return connection.getKey().getProviderUserId();
        }
    }
}