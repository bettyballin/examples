import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Temp1514 {
    
    private CustomAuthenticationSuccessHandler customAuthentiatonSuccesshandler;

    public static void main(String[] args) {
        // Application logic here
    }

    @Autowired
    public Temp1514(CustomAuthenticationSuccessHandler customAuthentiatonSuccesshandler) {
        this.customAuthentiatonSuccesshandler = customAuthentiatonSuccesshandler;
    }

    @Autowired
    public void setCustomAuthentiatonSuccesshandler(CustomAuthenticationSuccessHandler customAuthentiatonSuccesshandler) {
        this.customAuthentiatonSuccesshandler = customAuthentiatonSuccesshandler;
    }

    // Assuming CustomAuthenticationSuccessHandler is a valid class in your application context
    public static class CustomAuthenticationSuccessHandler {
        // Handler implementation here
    }
}