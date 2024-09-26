import org.springframework.security.config.annotation.web.builders.WebSecurity;

public class Temp3144 {
    public static void main(String[] args) {
        // Main method content
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/foo-url");
    }
}