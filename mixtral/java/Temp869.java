import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class Temp869 {

    @Autowired
    private SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler;

    public static void main(String[] args) {
        Temp869 temp = new Temp869();
        temp.execute();
    }

    public void execute() {
        // Assuming you would have a method to use the injected dependency
        System.out.println("SavedRequestAwareAuthenticationSuccessHandler: " + savedRequestAwareAuthenticationSuccessHandler);
    }
}