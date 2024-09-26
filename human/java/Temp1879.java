import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class Temp1879 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1879.class, args);
    }

    @Bean
    public ResourceServerConfigurerAdapter resourceServerConfigurer(final ScopesProperties oauthProperties) {
        return new ResourceServerConfigurerAdapter() {
            @Override
            public void configure(final HttpSecurity http) throws Exception {
                http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
                    .authorizeRequests()
                    .mvcMatchers(HttpMethod.GET, "/foo")
                    .access(oauthProperties.getFooRead())
                    .mvcMatchers(HttpMethod.GET, "/bar")
                    .access(oauthProperties.getBarRead())
                    .mvcMatchers(HttpMethod.PUT, "/bar")
                    .access(oauthProperties.getBarWrite())
                    // everything else
                    .anyRequest().denyAll();
            }
        };
    }

    // Dummy ScopesProperties class for demonstration
    public static class ScopesProperties {
        public String getFooRead() {
            return "hasAuthority('SCOPE_foo.read')";
        }

        public String getBarRead() {
            return "hasAuthority('SCOPE_bar.read')";
        }

        public String getBarWrite() {
            return "hasAuthority('SCOPE_bar.write')";
        }
    }
}