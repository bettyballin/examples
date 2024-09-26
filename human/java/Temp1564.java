import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1564 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Application entry point
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/homepage**").hasRole("USER")
            .antMatchers("/index**").permitAll()
            .antMatchers("/login**").permitAll()
            .and()
            .formLogin();
            //.loginPage( "/login" )
            //.loginProcessingUrl( "/login" )
            //.defaultSuccessUrl( "/index" );
        http.csrf().disable();
    }
}