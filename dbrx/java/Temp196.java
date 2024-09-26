import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp196 {
    public static void main(String[] args) throws Exception {
        HttpSecurity http = getHttpSecurity();
        http.authorizeRequests()
            .requestMatchers(new AntPathRequestMatcher("/about")).authenticated(); // Matches /about and /about.foo
    }

    // Mock method to provide HttpSecurity instance for demonstration purposes
    private static HttpSecurity getHttpSecurity() throws Exception {
        return HttpSecurity.class.getDeclaredConstructor().newInstance();
    }
}