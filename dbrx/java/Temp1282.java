import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Temp1282 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1282.class, args);
    }

    @Configuration
    public static class DatabaseConfig {
        @Autowired
        private DataSource primaryDataSource;

        @Bean
        public UserDetailsService userDetailsService() {
            JdbcUserDetailsManager service = new JdbcUserDetailsManager(primaryDataSource);
            String usersByUserNameQuery =
                "SELECT id, username, password, first_name as firstName, last_name as lastName, email FROM user WHERE username = ?";
            service.setUsersByUsernameQuery(usersByUserNameQuery);
            return service;
        }
    }
}