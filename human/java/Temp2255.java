import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

public class Temp2255 {
    public static void main(String[] args) {
        // This main method is just for illustration purposes
        // Since configuration methods like configure(WebSecurity web) 
        // are typically called by the Spring framework, not manually
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST, "/updatepass/**");
    }
}