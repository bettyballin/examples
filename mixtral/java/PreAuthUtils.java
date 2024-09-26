import org.springframework.stereotype.Component;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Component(value = "preAuthUtils")
public class PreAuthUtils {

    public boolean test(UsernamePasswordAuthenticationToken x) {
        System.out.println("type: " + x.getClass().getSimpleName());
        System.out.println("string: " + x.toString());

        final Object user = x.getPrincipal();

        if (user instanceof DefaultUserDetails) {
            // Now you can access the id and other properties of your custom UserDetails implementation

            var defaultUserDetails = (DefaultUserDetails) user;

            System.out.println("type: " + defaultUserDetails.getClass().getSimpleName());

        } else if (user instanceof String) {

            // Handle the case when principal is a string

        }

        return true;
    }

    public static void main(String[] args) {
        DefaultUserDetails userDetails = new DefaultUserDetails(); // Ensure this class exists
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, "password");
        PreAuthUtils utils = new PreAuthUtils();
        utils.test(token);
    }
}

class DefaultUserDetails {
    // Add necessary fields and methods for this class
}