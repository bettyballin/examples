import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Temp3641 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3641.class, args);
    }

    @Bean
    public Jwt2AuthenticationConverter authenticationConverter(Jwt2AuthoritiesConverter authoritiesConverter) {
        return jwt -> new MyAuthentication(jwt, authoritiesConverter.convert(jwt));
    }
}

// Dummy classes for demonstration
class Jwt2AuthenticationConverter {
    public MyAuthentication convert(String jwt) {
        // Implementation here
        return new MyAuthentication(jwt, null);
    }
}

class Jwt2AuthoritiesConverter {
    public Object convert(String jwt) {
        // Implementation here
        return new Object();
    }
}

class MyAuthentication {
    private String jwt;
    private Object authorities;

    public MyAuthentication(String jwt, Object authorities) {
        this.jwt = jwt;
        this.authorities = authorities;
    }
}