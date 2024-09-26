import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp1569 {
    
    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public static void main(String[] args) throws Exception {
        Temp1569 temp = new Temp1569();
        temp.inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        temp.configure(new AuthenticationManagerBuilder(null));
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder users = User.withDefaultPasswordEncoder();
        auth.userDetailsService(inMemoryUserDetailsManager);

        // Add new user to the custom implementation of InMemoryUserDetailsManager
        UserDetails user = users.username("FOO2").password("<PASSWORD>").roles("USER").build();
        inMemoryUserDetailsManager.createUser(user);
    }
}