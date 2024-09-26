import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.PortMapper;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig33 {

    // Assuming MyPortMapper is a valid implementation of PortMapper
    class MyPortMapper implements PortMapper {
        // Implementation details of MyPortMapper
    }

    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .requiresChannel()
                .requestMatchers(/* some matchers */)
                .requiresSecure()
                .and()
                .portMapper()
                .portMapper(new MyPortMapper());
        return httpSecurity.build();
    }
}