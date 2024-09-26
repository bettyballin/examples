import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.jdbc.JdbcUserDetailsManager;
import org.springframework.security.core.userdetails.jdbc.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class Temp1317 {

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager mgr = new JdbcUserDetailsManager();
        mgr.setDataSource(dataSource); // (1)
        return mgr;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, JdbcUserDetailsManager userDetailsManager, DataSource dataSource, PasswordEncoder enc) throws Exception {
        //set user detail service manually
        auth.userDetailsService(userDetailsManager);
        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> conf =
                new JdbcUserDetailsManagerConfigurer<>(userDetailsManager);
        //apply the configurer
        auth.apply(conf);
        conf.dataSource(dataSource) // (2)
                .withDefaultSchema().passwordEncoder(enc)
                .withUser("user").password(enc.encode("password")).roles("USER").and()
                .withUser("admin").password(enc.encode("password")).roles("USER", "ADMIN");
    }

    public static void main(String[] args) {
        // This is where you can initialize your application context if needed.
    }
}