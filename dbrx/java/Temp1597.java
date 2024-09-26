import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Temp1597 {

    @Autowired(required = false)
    private org.springframework.security.core.Authentication authentication;

    public static void main(String[] args) {
        System.out.println("Temp1597 class loaded successfully.");
    }
}