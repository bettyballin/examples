import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import lombok.SneakyThrows;

public class Temp2613 {
    
    private static final String SESSION_ID = "session-id";

    public static void main(String[] args) {
        Temp2613 temp = new Temp2613();
        RequestHeaderAuthenticationFilter filter = temp.preAuthenticationFilter();
        System.out.println("Filter Initialized: " + filter);
    }

    @Bean
    @SneakyThrows
    public RequestHeaderAuthenticationFilter preAuthenticationFilter() {
        RequestHeaderAuthenticationFilter preAuthenticationFilter = new RequestHeaderAuthenticationFilter();
        preAuthenticationFilter.setPrincipalRequestHeader(SESSION_ID);
        preAuthenticationFilter.setCredentialsRequestHeader(SESSION_ID);
        preAuthenticationFilter.setExceptionIfHeaderMissing(false);
        preAuthenticationFilter.setContinueFilterChainOnUnsuccessfulAuthentication(true);
        preAuthenticationFilter.setAuthenticationManager(authenticationManager());

        return preAuthenticationFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return authentication -> {
            // Stub implementation for AuthenticationManager
            System.out.println("AuthenticationManager called");
            return authentication;
        };
    }
}