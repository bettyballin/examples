import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@Order(90)
public class SecondProjectConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        // Configure the default user
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        authManagerBuilder.inMemoryAuthentication()
            .withUser(users.username("FOO").password("BAR").roles("USER").build())
            .withUser(users.username("FOO2").password("BAR").roles("USER").build());
    }
}