import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import javax.sql.DataSource;

public class SecurityConfig102 {
    private final DataSource dataSource;

    public SecurityConfig102(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager service = new JdbcUserDetailsManager(dataSource);
        service.setUsersByUsernameQuery("select username, password, true as enabled from user where username = ?");
        service.setAuthoritiesByUsernameQuery("select user.username, role.name from users_role " +
                "inner join role on role.id = users_role.role_id " +
                "inner join user on user.id = users_role.user_id " +
                "where user.username = ?");
        return service;
    }
}