import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public JdbcClientDetailsService myJdbcClientDetailsService(DataSource dataSource) {
        return new JdbcClientDetailsService(dataSource);
    }

    @Bean
    public ClientDetailsUserDetailsService clientDetailsUserService(JdbcClientDetailsService myJdbcClientDetailsService) {
        return new ClientDetailsUserDetailsService(myJdbcClientDetailsService);
    }
}