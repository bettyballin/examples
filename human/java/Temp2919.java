import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

@SpringBootApplication
public class Temp2919 implements CommandLineRunner {

    @Autowired
    private JdbcClientDetailsService jdbcClientDetailsService;

    public static void main(String[] args) {
        SpringApplication.run(Temp2919.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String companyId = "companyId";
        String resourceIds = "resourceIds";
        String scopes = "scopes";
        String grantTypes = "grantTypes";
        String authorities = "authorities";

        BaseClientDetails clientDetails = new BaseClientDetails(companyId, resourceIds, scopes, grantTypes, authorities);
        clientDetails.setClientSecret("generatedpassword");
        jdbcClientDetailsService.addClientDetails(clientDetails);
    }

    @Bean
    public JdbcClientDetailsService jdbcClientDetailsService(DataSource dataSource) {
        return new JdbcClientDetailsService(dataSource);
    }
}