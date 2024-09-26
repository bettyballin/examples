import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.OAuth2AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class OAuth2ServerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    private static DataSource dataSource;

    @Autowired
    private void setDataSource(DataSource dataSourcee) {
        dataSource = dataSourcee;
    }

    @Configuration
    @Order(1)
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends OAuth2AuthorizationServerConfigurerAdapter {

        private TokenStore tokenStore = new JdbcTokenStore(dataSource);

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.jdbc(dataSource);
        }

        @Bean
        public TokenStore tokenStore() {
            return new JdbcTokenStore(dataSource);
        }
    }
}