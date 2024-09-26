import java.util.Collections;
import java.util.Map;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.PortMapper;
import org.springframework.security.web.server.PortMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp2981 {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.requiresChannel()
                .anyRequest()
                .requiresSecure()
                .and()
                .portMapper()
                .portMapper(portMapper());

        return http.build();
    }

    @Bean
    public PortMapper portMapper() {
        PortMapperImpl portMapper = new PortMapperImpl();
        portMapper.setPortMappings(Collections.singletonMap(80, 443));
        return portMapper;
    }

    public static void main(String[] args) {
        // Spring Boot application context initialization typically goes here
        // For a complete running example, this code needs to be part of a Spring Boot application.
    }
}