import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import javax.sql.DataSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

public class SecurityConfiguration3 {

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager mgr = new JdbcUserDetailsManager();
        mgr.setDataSource(dataSource);
        return mgr;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, JdbcUserDetailsManager userDetailsManager, DataSource dataSource, PasswordEncoder encoder) throws Exception {
        auth.userDetailsService(userDetailsManager);
        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> conf = new JdbcUserDetailsManagerConfigurer<>(userDetailsManager);
        auth.apply(conf);
        conf.dataSource(dataSource)
                .withDefaultSchema()
                .passwordEncoder(encoder)
                .withUser(User.withUsername("user").password(encoder.encode("password")).roles("USER").build())
                .withUser(User.withUsername("admin").password(encoder.encode("password")).roles("USER", "ADMIN").build());
    }
}