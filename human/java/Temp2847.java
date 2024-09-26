import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

public class Temp2847 {

    private DataSource dataSource;
    private String usernameQuery;
    private String authoritiesQuery;

    public Temp2847(DataSource dataSource, String usernameQuery, String authoritiesQuery) {
        this.dataSource = dataSource;
        this.usernameQuery = usernameQuery;
        this.authoritiesQuery = authoritiesQuery;
    }

    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource)
                .usersByUsernameQuery(usernameQuery)
                .authoritiesByUsernameQuery(authoritiesQuery);
    }

    public static void main(String[] args) {
        // This is just a placeholder for the main method
        System.out.println("Temp2847 class executed");
    }
}