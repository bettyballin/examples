import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1605 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .oauth2ResourceServer()
                .opaqueToken()
                    .introspectionUri("http://localhost:8095")
                    .tokenIntrospector(customOpaqueTokenIntrospector())
                .and()
            .authenticationEntryPoint((request, response, authException) -> {
                // Handle authentication exceptions
            });
    }

    private Object customOpaqueTokenIntrospector() {
        // Return a custom token introspector
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Temp1605 application started.");
    }
}