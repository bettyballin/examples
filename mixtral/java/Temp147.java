import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableScheduling
public class Temp147 {

    public static void main(String[] args) {
        SpringApplication.run(Temp147.class, args);
    }

    @Scheduled(fixedDelay = 60_000)
    @PreAuthorize("hasRole('list_users_permission')")
    @WithUserDetails("scheduler-user")
    public void scheduledJob() {
        // Your code here
        System.out.println("Scheduled job executed");
    }
}

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}