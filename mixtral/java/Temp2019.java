import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2019 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Execution starts here
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);

        // Allow swagger-ui and api-docs requests
        web
            .ignoring()
            .antMatchers("/v3/api-docs/**", "/swagger-ui.html**");
    }
}