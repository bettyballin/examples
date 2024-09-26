import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public class Temp1054 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        new Temp1054().httpCorsConfiguration();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(corsConfigurationSource());
    }

    private void httpCorsConfiguration() {
        try {
            HttpSecurity http = getHttp();
            configure(http);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HttpSecurity getHttp() throws Exception {
        return new HttpSecurity(null, null, null);
    }

    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); 
        configuration.addAllowedMethod("*"); 
        configuration.addAllowedHeader("*"); 

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}