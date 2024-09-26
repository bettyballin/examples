import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class Temp870 {
    public static void main(String[] args) {
        SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler = new SavedRequestAwareAuthenticationSuccessHandler();

        // Assuming `http` and `customLoginSucessHandler` are defined and configured properly in your context
        // http.formLogin() 
        //     .successHandler(savedRequestAwareAuthenticationSuccessHandler)
        //     .and().exceptionHandling();

        // Set up a custom target URL resolver
        savedRequestAwareAuthenticationSuccessHandler.setTargetUrlParameter("customTargetUrl");
    }
}