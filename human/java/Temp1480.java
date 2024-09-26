import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class Main {
    public static void main(String[] args) {
        SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
        failureHandler.setUseForward(true);

        System.out.println("Failure Handler useForward is set to: " + failureHandler.isUseForward());
    }
}