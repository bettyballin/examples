import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

public class Temp3139 {
    public static void main(String[] args) throws Exception {
        Temp3139 temp = new Temp3139();
        temp.configureHttpSecurity();
    }

    public void configureHttpSecurity() throws Exception {
        HttpSecurity http = new HttpSecurity();
        http.requestMatcher(new RequestHeaderRequestMatcher("Authorization"))
            .authorizeRequests()
            .antMatchers("/**").authenticated()
            .antMatchers(HttpMethod.GET, "/beers").permitAll();
    }
}


Note: This code is intended to be part of a Spring Security configuration. It will not work as a standalone Java application. To make it fully functional, it should be integrated into a Spring Boot project with the necessary dependencies.