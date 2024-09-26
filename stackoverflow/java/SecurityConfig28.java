import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig28 extends WebSecurityConfig28urerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("resource-serv")
                .scopes("read")
                .resourceIds("my-resource")
                .secret(passwordEncoder().encode("secret123"))
                .and()
                .withClient("app")
                .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                .scopes("read")
                .resourceIds("my-resource")
                .secret(passwordEncoder().encode("appclientsecret"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Deprecated but used here for simplicity. Use a stronger encoder in production.
        return NoOpPasswordEncoder.getInstance();
    }
}