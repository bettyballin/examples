import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3294 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            // You can also ignore other resources like images, fonts, etcetera
            .antMatchers("/**/*.js")
            .antMatchers("/**/*.css");
    }
}


To execute this code, you need to have Spring Security in your classpath. Ensure you have the necessary dependencies and a Spring Boot application setup if you are running this in a Spring Boot project.