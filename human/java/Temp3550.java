import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

public class Temp3550 {

    private DataSource dataSource;

    public Temp3550(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        // This main method is just a placeholder.
        // Spring Boot application would typically be started differently.
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select voornaam as username, password as password, true as enabled from gebruikers where voornaam = ?")
            .passwordEncoder(passwordEncoder())
            .authoritiesByUsernameQuery("select voornaam as username, role as authorities from gebruikers where voornaam = ?");
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}