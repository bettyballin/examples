import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig36urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig36 extends WebSecurityConfig36urerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().contentSecurityPolicy("script-src 'self' https://myclientscriptlocation.example.com; object-src https://myclientsideplugins.example.com; report-uri /cspreport-endpoint/");
    }
}