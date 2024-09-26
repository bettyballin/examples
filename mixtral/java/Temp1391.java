import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class Temp1391 {
    public static void main(String[] args) {

        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl("https://my.production.com/authorities");

        // Assuming http is an instance of HttpSecurity
        // HttpSecurity http = ...

        // ...

        // Uncomment the following block when you have the HttpSecurity instance
        /*
        http
            .formLogin()
                // other form login configurations
                .successHandler(successHandler);
        */
    }
}