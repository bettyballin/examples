import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationServlet {

    private AuthenticationManager authenticationManager;

    public AuthenticationServlet(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Authentication requestToken = new UsernamePasswordAuthenticationToken(username, password);

        try {
            Authentication resultToken = authenticationManager.authenticate(requestToken);
            SecurityContextHolder.getContext().setAuthentication(resultToken);
            // Continue the rest of the processing
        } catch (AuthenticationException e) {
            throw new ServletException("Authentication failed", e);
        }
    }
}