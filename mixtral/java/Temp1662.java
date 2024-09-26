import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.JdbcClientDetailsServiceBuilder;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@EnableAuthorizationServer
public class Temp1662 extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private String dialect;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        JdbcClientDetailsServiceBuilder builder = new JdbcClientDetailsServiceBuilder();

        // Configure the datasource and SQL dialect
        builder.dataSource(this.dataSource);

        if (dialect != null) {
            builder.withDialect(dialect);
        }

        clients
                .jdbc(builder)
                .clientsByClientIdQuery("SELECT client_id, CONCAT('{noop}', client_secret) AS secret, scope, authorized_grant_types, web_server_redirect_uri FROM oauth2_client WHERE client_id=?")
                .authoritiesByClientIdQuery("SELECT client_id, authority FROM authorities WHERE client_id = ?")
                .autoApproveScopes(Collections.singletonList("read"));
    }

    public static void main(String[] args) {
        // This main method can be used to launch the application if needed
    }
}