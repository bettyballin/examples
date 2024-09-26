import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@Order(90)
@EnableWebSecurity
public class SecondProjectConfiguration extends AuthConfiguration {

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        super.configure(authManagerBuilder); // it creates FOO user

        UserDetails user = User.withDefaultPasswordEncoder()
            .username("FOO2")
            .password("BAR")
            .roles("USER")
            .build();

        authManagerBuilder.inMemoryAuthentication()
            .withUser(user);
    }   
}