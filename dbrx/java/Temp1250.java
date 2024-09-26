import org.springframework.http.HttpMethod;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

public class Temp1250 {

    public static void main(String[] args) {
        // Example placeholder for http variable
        HttpSecurity http = new HttpSecurity();

        http.logout()
            .requiresLogout(ServerWebExchangeMatchers.pathMatchers(HttpMethod.GET, "/logout"))
            .logoutSuccessUrl("/after-logout")
            .and().build();
    }
}

// Placeholder classes to mimic actual Spring Security classes
class HttpSecurity {
    public LogoutSpec logout() {
        return new LogoutSpec(this);
    }

    public HttpSecurity and() {
        return this;
    }
    
    public void build() {
        System.out.println("Build complete");
    }
}

class LogoutSpec {
    private HttpSecurity http;

    public LogoutSpec(HttpSecurity http) {
        this.http = http;
    }

    public LogoutSpec requiresLogout(Object matcher) {
        System.out.println("Logout required at: " + matcher);
        return this;
    }

    public LogoutSpec logoutSuccessUrl(String url) {
        System.out.println("Logout success URL: " + url);
        return this;
    }

    public HttpSecurity and() {
        return this.http;
    }
}