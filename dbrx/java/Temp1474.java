import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class Temp1474 extends UsernamePasswordAuthenticationFilter {
    public static void main(String[] args) {
        // Main method contents (if any) would go here
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        super.successfulAuthentication(request, response, chain, authResult);

        // Your additional logic here, if any
        // For example: User user = (User) authResult.getPrincipal();
    }
}