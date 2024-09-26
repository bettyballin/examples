import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

public class Temp2495 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatcher(PathRequest.toStaticResources().atCommonLocations())
            .authorizeRequests(authorize -> authorize
                .anyRequest().permitAll()
            );
    }

    public static void main(String[] args) {
        System.out.println("Temp2495 application started.");
    }
}