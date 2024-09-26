import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1535 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // You can run this Spring Boot application to test the configuration
        org.springframework.boot.SpringApplication.run(Temp1535.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/", "/index", "/subscribe", "/paypal").permitAll()
            .regexMatchers("\\A/user(\\..*)?\\Z")
                .hasAnyAuthority(ROL.ADMIN.getName())
            .anyRequest().authenticated();
    }
}

// Assuming ROL is an enum defined somewhere in your project
enum ROL {
    ADMIN;

    public String getName() {
        return name();
    }
}