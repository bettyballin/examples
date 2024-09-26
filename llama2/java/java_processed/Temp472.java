import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp472 {
    public static void main(String[] args) {
        // Assuming "user" is a valid user object. For this example, we use a simple string.
        String user = "exampleUser";

        // Creating the principal using UsernamePasswordAuthenticationToken
        Authentication principal = new UsernamePasswordAuthenticationToken(user, "password");

        // Setting the authentication in the security context (if using Spring Security)
        SecurityContextHolder.getContext().setAuthentication(principal);

        // Output the principal to verify
        System.out.println("Principal: " + principal.getName());
    }
}
//Add the following jars to your classpath to compile and run the code. You can download them from Maven repository.
//spring-security-core-5.7.3.jar
//spring-core-5.3.22.jar
//spring-context-5.3.22.jar
//spring-beans-5.3.22.jar