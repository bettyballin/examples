import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;

@SpringBootApplication
public class Temp264 {

    public static void main(String[] args) {
        SpringApplication.run(Temp264.class, args);
    }

    @Bean
    public SwitchUserFilter switchUserFilter() {
        SwitchUserFilter filter = new SwitchUserFilter();
        
        // Set your own target URL where users will be redirected after switching
        filter.setTargetUrl("/");
        
        return filter;
    }

    // Add the following to configure HttpSecurity
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
              .anyRequest().authenticated()
              .and()
          .formLogin()
              .and()
          // Enable switch user feature
          .addFilter(switchUserFilter());
    }
}