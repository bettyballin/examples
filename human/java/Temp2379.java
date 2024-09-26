import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAuthorizationServer
public class Temp2379 extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource); // Get clients from database, table = oauth_client_details
    }

    public static void main(String[] args) {
        // Spring Boot application entry point code would go here
        // SpringApplication.run(Temp2379.class, args);
    }
}