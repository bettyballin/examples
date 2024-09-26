import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
public class AdditionalUsersConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder users = User.builder();
        
        auth.inMemoryAuthentication()
            .withUser(users.username("FOO2").password("{noop}BAR").roles("USER"))
            .withUser(users.username("FOO3").password("{noop}BAR").roles("ADMIN"));
    }
}