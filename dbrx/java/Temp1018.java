import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityConfigurerAdapter;

public class Temp1018 extends SecurityConfigurerAdapter<HttpSecurity> {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    public static void main(String[] args) {
        try {
            HttpSecurity http = new HttpSecurity(null, null, null);
            Temp1018 temp = new Temp1018();
            temp.configure(http);
            System.out.println("Session management policy set to STATELESS.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}