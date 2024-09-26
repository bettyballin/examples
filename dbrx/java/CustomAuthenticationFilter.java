import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {

        String jsessionid = (String) req.getAttribute("jsessionid");
        if (jsessionid != null) {
            // set the JSESSIONID as a request attribute for Cometd to use.
            req.setAttribute("cometd.jsessionid", jsessionid);
        }

        return super.attemptAuthentication(req, res);
    }

    public static void main(String[] args) {
        // This main method is only for testing purpose.
        // In a real-world application, this filter would be part of a Spring Security configuration.
        System.out.println("CustomAuthenticationFilter loaded.");
    }
}