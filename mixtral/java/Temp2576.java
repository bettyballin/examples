import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.http.HttpServletRequest;

public class Temp2576 {
    @Autowired
    private HttpServletRequest request;

    public static void main(String[] args) {
        Temp2576 temp = new Temp2576();
        System.out.println("Is Authenticated: " + temp.isAuthenticated());
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder
            .getContext().getAuthentication();

        return (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
                && authentication.isAuthenticated());
    }
}