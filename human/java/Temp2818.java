import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.cache.NullUserCache;

public class Temp2818 extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private UserCache userCache;

    public Temp2818() {
        dataSource = dataSource();
        userCache = userCache();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).userCache(userCache);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("user");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public UserCache userCache() {
        return new NullUserCache();
    }

    public static void main(String[] args) {
        // This main method is not needed for Spring Boot applications,
        // but can be used to run as a standalone Java application.
        org.springframework.boot.SpringApplication.run(Temp2818.class, args);
    }
}